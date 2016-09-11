package ru.home.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.home.shop.domain.bean.PresentBean;
import ru.home.shop.domain.bean.Report;
import ru.home.shop.exception.ResourceNotFoundException;
import ru.home.shop.service.PresentService;
import ru.home.shop.service.ReportService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
public class ReportController {

    private final PresentService presentService;
    private final ReportService reportService;

    @Autowired
    public ReportController(PresentService presentService, ReportService reportService) {
        this.presentService = presentService;
        this.reportService = reportService;
    }

    @RequestMapping(value = "/present/publicReport/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> publicReport(@PathVariable("id") int presentId, HttpServletResponse response) {
        PresentBean present = presentService.find(presentId);

        if (present == null) {
            throw new ResourceNotFoundException();
        }

        Report report = reportService.publicReport(present);

        return toResponseEntity(report);
    }

    @RequestMapping(value = "/present/privateReport/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> privateReport(@PathVariable("id") int presentId) throws IOException {
        PresentBean present = presentService.find(presentId);

        if (present == null) {
            throw new ResourceNotFoundException();
        }

        Report report = reportService.privateReport(present);

        return toResponseEntity(report);
    }

    private ResponseEntity<byte[]> toResponseEntity(Report report) {
        String fileName;
        try {
            fileName = URLEncoder.encode(report.getName(), "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        final HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        headers.set("Content-Disposition", "attachment; filename*=UTF-8''" + fileName);

        return new ResponseEntity<>(report.getContent(), headers, HttpStatus.OK);
    }
}
