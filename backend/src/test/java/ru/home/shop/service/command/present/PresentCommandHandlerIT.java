package ru.home.shop.service.command.present;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import ru.home.shop.api.present.CreatePresentCommand;
import ru.home.shop.api.present.PresentItem;
import ru.home.shop.api.present.RemovePresentCommand;
import ru.home.shop.service.DBRiderIT;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import static ru.home.db.Tables.CANDY;
import static ru.home.db.Tables.PRESENT;
import static ru.home.shop.utils.UuidUtils.newUUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PresentCommandHandlerIT extends DBRiderIT {

    private static final UUID PRESENT_ID = UUID.fromString("9744b2ea-2328-447c-b437-a4f8b57c9985");
    private static final String PRESENT_NAME = "name";
    private static final BigDecimal PRESENT_PRICE = BigDecimal.valueOf(12.35);
    private static final LocalDateTime PRESENT_DATE = LocalDateTime.of(2017, 1, 1, 12, 0);

    @Autowired
    private PresentCommandHandler eventHandler;

    public PresentCommandHandlerIT() {
        cleanDataAfterClass(PRESENT, CANDY);
    }

    private CreatePresentCommand createPresentCommand() {
        List<PresentItem> items = new ArrayList<>();
        items.add(new PresentItem(UUID.fromString("a58051ef-ea6c-4565-aefd-0e2d260bf95d"), UUID.fromString("a764c765-483c-492b-ac63-4f2c4f6d2ff4"), 2));
        items.add(new PresentItem(UUID.fromString("f93944ca-ab01-4f68-b635-6e239efdbb4f"), UUID.fromString("7a8d3659-81e8-49aa-80fb-3121fee7c29c"), 6));

        return new CreatePresentCommand(PRESENT_ID, PRESENT_NAME, PRESENT_PRICE, PRESENT_DATE, items);
    }

    @Test
    @DataSet({"present/present_empty.yml", "candy/candy_list.yml"})
    @ExpectedDataSet("present/present.yml")
    public void addPresentShouldInsertRecord() {
        eventHandler.on(createPresentCommand());
    }

    @Test
    @DataSet({"candy/candy_list.yml", "present/present.yml"})
    @ExpectedDataSet("present/present_empty.yml")
    public void removeExistentEntityShouldRemoveRecord() {
        eventHandler.on(new RemovePresentCommand(PRESENT_ID));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    @DataSet("present/present_empty.yml")
    public void removeNonexistentEntityShouldThrowException() {
        eventHandler.on(new RemovePresentCommand(newUUID()));
    }
}