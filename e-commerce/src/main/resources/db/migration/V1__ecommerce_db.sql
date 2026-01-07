-- Drop tables if they exist
DROP TABLE IF EXISTS `brand`;
DROP TABLE IF EXISTS `category`;
DROP TABLE IF EXISTS `image`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `product_tag`;
DROP TABLE IF EXISTS `review`;
DROP TABLE IF EXISTS `tag`;
DROP TABLE IF EXISTS `variant`;

-- Create tables
CREATE TABLE `brand` (
  `brand_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  `logo_url` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `category` (
  `category_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `description` text,
  `logo_url` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `image` (
  `image_id` bigint NOT NULL,
  `image_url` varchar(250) NOT NULL,
  `alt_text` varchar(250) NOT NULL,
  `is_primary` tinyint DEFAULT NULL,
  `sort_order` int DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_name` varchar(250) NOT NULL,
  `description` text,
  `base_price` decimal(10,2) DEFAULT NULL,
  `sale_percentage` int DEFAULT NULL,
  `is_on_sale` tinyint DEFAULT NULL,
  `is_available` tinyint DEFAULT NULL,
  `moq` int DEFAULT NULL,
  `material_composition` varchar(250) DEFAULT NULL,
  `badge` varchar(100) DEFAULT NULL,
  `average_rating` double DEFAULT NULL,
  `review_count` int DEFAULT NULL,
  `is_free_delivery` tinyint DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `date_added` timestamp(4) NULL DEFAULT NULL,
  `meta_title` varchar(100) DEFAULT NULL,
  `slug` varchar(250) DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `brand_id` bigint NOT NULL,
  `productscol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `product_tag` (
  `product_id` bigint NOT NULL,
  `tag_id` bigint NOT NULL,
  PRIMARY KEY (`product_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `review` (
  `review_id` bigint NOT NULL,
  `rating` int NOT NULL,
  `review_text` text,
  `date_created` timestamp(4) NULL DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`review_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tag` (
  `tag_id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `variant` (
  `variant_id` int NOT NULL,
  `size` varchar(100) DEFAULT NULL,
  `color` varchar(100) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `is_available` tinyint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`variant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Insert initial data
INSERT INTO `brand` VALUES
    (1,'Sony',NULL,NULL),
    (2,'Samsung',NULL,NULL),
    (3,'LG',NULL,NULL),
    (4,'Apple',NULL,NULL),
    (5,'Bose',NULL,NULL);

INSERT INTO `category` VALUES
    (1,'Electronics','Devices and gadgets such as TVs, headphones, and speakers',NULL),
    (2,'Home Appliances','Appliances for home use like refrigerators, ovens, and washing machines',NULL),
    (3,'Computers & Accessories','Desktops, laptops, and computer peripherals',NULL),
    (4,'Smartphones','Mobile phones and accessories',NULL),
    (5,'Audio Equipment','Speakers, headphones, and other audio devices',NULL);

INSERT INTO `product` VALUES
    (1,'LED Light Bulb 12W','Energy saving LED bulb with bright white light',15.00,10,1,1,10,'Plastic & Aluminum','Best Seller',4.5,120,1,0.2,'2026-01-06 12:44:29.0000','LED Light Bulb','led-light-bulb-12w',1,1,'ELECTRICAL'),
    (2,'Electric Kettle 1.7L','Fast boiling electric kettle with auto shut-off',40.00,15,1,1,5,'Stainless Steel','Hot Deal',4.3,95,1,1.1,'2026-01-06 12:44:29.0000','Electric Kettle','electric-kettle-17l',1,2,'ELECTRICAL'),
    (3,'Extension Power Strip','4-socket extension power strip with surge protection',20.00,0,0,1,20,'Plastic & Copper','New',4.2,60,0,0.8,'2026-01-06 12:44:29.0000','Power Strip','extension-power-strip',1,1,'ELECTRICAL'),
    (4,'USB Wall Charger','Dual USB fast wall charger',18.00,5,1,1,15,'Plastic',NULL,4.4,70,1,0.3,'2026-01-06 12:44:29.0000','USB Wall Charger','usb-wall-charger',1,3,'ELECTRICAL'),
    (5,'Smart Plug WiFi','WiFi smart plug with mobile app control',35.00,20,1,1,5,'Plastic','Smart',4.6,150,1,0.4,'2026-01-06 12:44:29.0000','Smart Plug','smart-plug-wifi',1,2,'ELECTRICAL'),
    (6,'Table Fan 16 Inch','High-speed table fan with adjustable tilt',55.00,0,0,1,2,'Plastic & Metal',NULL,4.1,40,0,3.5,'2026-01-06 12:44:29.0000','Table Fan','table-fan-16-inch',1,1,'ELECTRICAL'),
    (7,'Electric Iron','Non-stick electric iron with steam function',45.00,10,1,1,3,'Metal & Plastic','Popular',4.3,85,1,1.4,'2026-01-06 12:44:29.0000','Electric Iron','electric-iron-steam',1,3,'ELECTRICAL'),
    (8,'Power Bank 10000mAh','Portable power bank with fast charging',60.00,25,1,1,10,'Plastic & Lithium Battery','Top Rated',4.7,200,1,0.5,'2026-01-06 12:44:29.0000','Power Bank','power-bank-10000mah',1,2,'ELECTRICAL'),
    (9,'Surge Protector Adapter','Single socket surge protector adapter',12.00,0,0,1,25,'Plastic',NULL,4,30,0,0.2,'2026-01-06 12:44:29.0000','Surge Protector','surge-protector-adapter',1,1,'ELECTRICAL'),
    (10,'his device','Over-ear wireless headphones with noise cancellation',99.99,10,1,1,1,'Plastic, Aluminum','Best Seller',4.5,120,1,350,'2026-01-06 22:00:00.0000','Wireless Bluetooth Headphones','wireless-bluetooth-headphones',1,2,NULL);