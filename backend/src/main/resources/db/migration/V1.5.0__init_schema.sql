CREATE TABLE "candy" (
    "id" UUID NOT NULL,
    "active" BIT NOT NULL DEFAULT true,
    "name" NVARCHAR(50) NOT NULL,
    "firm" NVARCHAR(50) NULL,
    "price" DECIMAL(7, 2) NOT NULL,
    "order" DOUBLE NOT NULL DEFAULT '1.1',
    PRIMARY KEY ("id")
);

CREATE INDEX "list" on "candy" ("active", "order");

CREATE TABLE "present" (
    "id" UUID NOT NULL,
    "name" NVARCHAR (50) NOT NULL,
    "price" DECIMAL(8, 2) NOT NULL,
    "date" DATETIME NOT NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "present_item" (
    "present_id" UUID NOT NULL,
    "candy_id" UUID NOT NULL,
    "count" INT NOT NULL,
    PRIMARY KEY ("present_id", "candy_id"),
    FOREIGN KEY ("present_id") REFERENCES "present" ("id") ON DELETE CASCADE,
    FOREIGN KEY ("candy_id") REFERENCES "candy" ("id")
);