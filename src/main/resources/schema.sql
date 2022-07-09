DROP TABLE IF EXISTS products;

CREATE TABLE `products` (
  `product_id` int AUTO_INCREMENT  PRIMARY KEY,
  `description` varchar(100) NOT NULL,
  `category` char(4) NOT NULL,
  `quantity` int NOT NULL,
  `price` int NOT NULL,
  `prod_date` date DEFAULT NULL
);

