-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.29 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table foodshop.address: ~8 rows (approximately)
INSERT INTO `address` (`address_id`, `street_1`, `street_2`, `city_id`) VALUES
	(1, 'abc street ', '123', 1),
	(2, '233 ccc block', '123 street2', 1),
	(3, 'abcD block second floor', 'dvr state street ', 2),
	(4, 'acer streets ', 'mac pro street', 3),
	(5, 'ui longg 333', 'ux sttreet ', 1),
	(6, 'jonbones house', 'lol streets', 5),
	(7, 'azKick street', 'qe333', 6),
	(8, 'xay 222', 'no way street', 5);

-- Dumping data for table foodshop.bartender: ~0 rows (approximately)

-- Dumping data for table foodshop.bartender_role: ~2 rows (approximately)
INSERT INTO `bartender_role` (`bartender_role_id`, `bartender_role_name`) VALUES
	(1, 'Bartender'),
	(2, 'Barback'),
	(4, 'Sommelier');

-- Dumping data for table foodshop.cashier: ~0 rows (approximately)

-- Dumping data for table foodshop.chef: ~0 rows (approximately)
INSERT INTO `chef` (`chef_id`, `employee_id`, `chef_type_id`, `job_status_id`) VALUES
	(1, 1, 1, 1);

-- Dumping data for table foodshop.chef_type: ~7 rows (approximately)
INSERT INTO `chef_type` (`chef_type_id`, `chef_type_name`) VALUES
	(1, 'Main_Chef'),
	(2, 'Pastry_Chef'),
	(3, 'Bakery_Chef'),
	(4, 'Cafe_Chef'),
	(5, 'Line_Cook'),
	(6, 'Sous_Chef'),
	(7, 'Executive_Chef'),
	(8, 'Prep_Cook');

-- Dumping data for table foodshop.city: ~6 rows (approximately)
INSERT INTO `city` (`city_id`, `city_name`) VALUES
	(1, 'Kandy'),
	(2, 'Kurunegala'),
	(3, 'Matara'),
	(4, 'Jaffna'),
	(5, 'Ampara'),
	(6, 'Matale');

-- Dumping data for table foodshop.cleaner: ~0 rows (approximately)

-- Dumping data for table foodshop.cleaner_type: ~4 rows (approximately)
INSERT INTO `cleaner_type` (`cleaner_type_id`, `cleaner_type_name`) VALUES
	(1, 'Outdoor_Cleaner'),
	(2, 'Dish_Washer'),
	(3, 'Kitchen_Cleaner'),
	(4, 'Floor_Cleaner');

-- Dumping data for table foodshop.contain_method: ~4 rows (approximately)
INSERT INTO `contain_method` (`contain_method_id`, `contain_method_name`) VALUES
	(1, 'Glass_Jar'),
	(2, 'Boxes'),
	(3, 'Cans'),
	(4, 'Freezer'),
	(5, 'Packets');

-- Dumping data for table foodshop.customer_order: ~3 rows (approximately)
INSERT INTO `customer_order` (`customer_order_id`, `order_time_date`, `customer_table_id`, `server_id`, `total`, `unique_id`, `order_status_id`) VALUES
	(42, '2022-07-17 10:32:43', 3, 1, 63, '1cc15c35-a36d-4acd-a13c-0975df7c9ff01658034163413', 3),
	(43, '2022-07-17 10:39:47', 2, 1, 100, 'adc4deb6-0701-4c34-9850-8fe7531154241658034587598', 3),
	(44, '2022-07-17 10:40:36', 4, 2, 120, '0feb9daa-e9cd-4728-bc27-b28deb73b2511658034636455', 3),
	(45, '2022-07-17 20:52:16', 3, 1, 44, '2269851e-0839-499a-a8e3-bb16a00ce5671658071336259', 3),
	(46, '2022-07-18 00:06:04', 2, 1, 119, '774ae876-30fb-4c61-ad2a-3277edf546d91658082964185', 3);

-- Dumping data for table foodshop.customer_ordered_item: ~4 rows (approximately)
INSERT INTO `customer_ordered_item` (`customer_ordered_item_id`, `qty`, `customer_order_id`, `menuItemId`) VALUES
	(45, 3, 42, 13),
	(46, 3, 42, 14),
	(47, 5, 43, 5),
	(48, 3, 44, 8),
	(49, 3, 44, 4),
	(50, 4, 45, 13),
	(51, 4, 46, 14),
	(52, 1, 46, 7),
	(53, 1, 46, 4),
	(54, 2, 46, 12),
	(55, 1, 46, 6);

-- Dumping data for table foodshop.customer_payment: ~0 rows (approximately)

-- Dumping data for table foodshop.customer_table: ~10 rows (approximately)
INSERT INTO `customer_table` (`customer_table_id`, `customer_table_name`) VALUES
	(1, 'Table_1'),
	(2, 'Table_2'),
	(3, 'Table_3'),
	(4, 'Table_4'),
	(5, 'Table_5'),
	(6, 'Table_6'),
	(7, 'Table_7'),
	(8, 'Table_8'),
	(9, 'Table_9'),
	(10, 'Table_10');

-- Dumping data for table foodshop.dealer: ~2 rows (approximately)
INSERT INTO `dealer` (`dealer_id`, `dealer_name`, `dealer_contact`, `dealer_email`, `dealer_address_id`, `dealer_type_id`) VALUES
	(1, 'Jason Meat', '0725886333', 'jasonmeat11@gmail.com', 1, 2),
	(2, 'Cassealle Fishers', '0782365444', 'cassellefissy@gmail.com', 2, 1);

-- Dumping data for table foodshop.dealer_address: ~2 rows (approximately)
INSERT INTO `dealer_address` (`dealer_address_id`, `street_1`, `street_2`, `city_id`) VALUES
	(1, '123 street ', '111 ', 1),
	(2, '39/44 ANN Viddey', 'Ronaldo Apasrtment', 1);

-- Dumping data for table foodshop.dealer_type: ~7 rows (approximately)
INSERT INTO `dealer_type` (`dealer_type_id`, `dealer_type_name`) VALUES
	(1, 'fish'),
	(2, 'meat'),
	(3, 'dairy'),
	(4, 'rice'),
	(5, 'flour'),
	(6, 'vegetables'),
	(7, 'nuts'),
	(8, 'oil'),
	(9, 'crustacean');

-- Dumping data for table foodshop.employee: ~8 rows (approximately)
INSERT INTO `employee` (`employee_id`, `employee_name`, `employee_contact`, `employee_email`, `address_id`, `DOB`, `joined_date`, `gender_id`, `employee_type_id`) VALUES
	(1, 'Marshall Mathers', '0744585555', 'marshallmathers@gmail.com', 1, '1994-07-22', '2022-07-15', 1, 1),
	(2, 'Jason Bourne', '0758666532', 'jasonbourne@gmail.com', 2, '2001-07-20', '2022-07-15', 1, 2),
	(3, 'Jessy Rogers', '0741256565', 'jessyrogerose@gmail.com', 3, '1990-07-20', '2022-07-15', 2, 2),
	(4, 'Mark Boucher', '0723654899', 'markbouch@outlook.com', 4, '1991-07-12', '2022-07-15', 1, 1),
	(5, 'Marlon Samuels', '0785225656', 'msasmulesl323@yahoo.com', 5, '1995-07-21', '2022-07-16', 1, 6),
	(6, 'Lestor Bones', '0785225655', 'lestorbones@gmail.com', 6, '2000-07-29', '2022-07-16', 1, 3),
	(7, 'Valentian Chevchenko', '0763921454', 'velantioMMA@gmail.com', 7, '1991-07-15', '2022-07-16', 2, 6),
	(8, 'Valarie Bloha', '0741253699', 'valar@gmail.com', 8, '1991-07-16', '2022-07-16', 2, 6);

-- Dumping data for table foodshop.employee_salary: ~0 rows (approximately)

-- Dumping data for table foodshop.employee_type: ~5 rows (approximately)
INSERT INTO `employee_type` (`employee_type_id`, `employee_type_name`) VALUES
	(1, 'Chef'),
	(2, 'Manager'),
	(3, 'Cleaner'),
	(4, 'Bartender'),
	(5, 'Cashier'),
	(6, 'Server');

-- Dumping data for table foodshop.employee_working_hours: ~0 rows (approximately)

-- Dumping data for table foodshop.food_item: ~2 rows (approximately)
INSERT INTO `food_item` (`food_item_id`, `food_item_name`, `food_item_category_id`, `contain_method_id`) VALUES
	(1, 'beef breast ', 1, 4),
	(2, 'chicken breast', 2, 4),
	(3, 'beef legs', 1, 4);

-- Dumping data for table foodshop.food_item_category: ~11 rows (approximately)
INSERT INTO `food_item_category` (`food_item_category_id`, `food_item_category_name`, `dealer_type_id`) VALUES
	(1, 'beef', 2),
	(2, 'Chicken', 2),
	(3, 'cocunut', 8),
	(4, 'olive', 8),
	(5, 'tuna', 1),
	(6, 'cheese', 3),
	(7, 'coco', 7),
	(8, 'basmati', 4),
	(9, 'Arborio', 4),
	(10, 'wheat ', 5),
	(11, 'Chicken eggs', 2),
	(12, 'Shrimp', 9);

-- Dumping data for table foodshop.food_receive_item: ~9 rows (approximately)
INSERT INTO `food_receive_item` (`food_receive_item`, `food_receive_note_id`, `food_storage_id`, `buying_price`, `qty`) VALUES
	(1, 1, 1, 11, 12),
	(2, 2, 2, 4, 2),
	(3, 3, 3, 4, 4),
	(4, 4, 4, 33, 3),
	(5, 5, 5, 33, 33),
	(6, 6, 6, 2, 2),
	(7, 7, 1, 11, 40),
	(8, 8, 7, 22, 22),
	(9, 9, 8, 33, 3),
	(10, 10, 9, 11, 10),
	(11, 11, 10, 22, 22),
	(12, 11, 11, 44, 4);

-- Dumping data for table foodshop.food_receive_note: ~9 rows (approximately)
INSERT INTO `food_receive_note` (`food_receive_note_id`, `supplier_id`, `manager_id`, `received_datetime`, `unique_id`) VALUES
	(1, 1, 1, '2022-07-15 17:44:44', '1657887284072'),
	(2, 1, 1, '2022-07-16 19:31:16', '1657980076674'),
	(3, 1, 1, '2022-07-16 20:04:18', '1657982058635'),
	(4, 1, 1, '2022-07-16 20:21:45', '1657983105715'),
	(5, 1, 1, '2022-07-16 20:22:29', '1657983149252'),
	(6, 1, 1, '2022-07-16 20:23:28', '1657983208627'),
	(7, 1, 1, '2022-07-16 20:29:12', '1657983552171'),
	(8, 1, 1, '2022-07-16 20:30:20', '1657983620467'),
	(9, 1, 1, '2022-07-16 20:31:56', '1657983716105'),
	(10, 1, 1, '2022-07-16 20:32:52', '1657983772113'),
	(11, 1, 1, '2022-07-17 01:30:27', '1658001627045');

-- Dumping data for table foodshop.food_receive_payment: ~9 rows (approximately)
INSERT INTO `food_receive_payment` (`food_receive_payment_id`, `amount`, `balance`, `payment_method_id`, `food_receive_note_id`) VALUES
	(1, 132, 0.020000000000010232, 1, 1),
	(2, 8, 0.08000000000000007, 1, 2),
	(3, 16, 0.05999999999999872, 1, 3),
	(4, 44, 55.040000000000006, 1, 4),
	(5, 333, 756.03, 1, 5),
	(6, 2, 2.0199999999999996, 1, 6),
	(7, 441, -4000.99, 1, 7),
	(8, 344, 140.04000000000002, 1, 8),
	(9, 44, 55.040000000000006, 1, 9),
	(10, 111, -0.9899999999999949, 1, 10),
	(11, 660, 0, 1, 11);

-- Dumping data for table foodshop.food_storage: ~9 rows (approximately)
INSERT INTO `food_storage` (`food_storage_id`, `food_item_id`, `qty`, `mfd`, `exp`) VALUES
	(1, 1, 40, '2022-07-07', '2022-07-09'),
	(2, 1, 2, '2022-07-07', '2022-07-16'),
	(3, 1, 4, '2022-07-13', '2022-07-21'),
	(4, 1, 3, '2022-07-08', '2022-07-16'),
	(5, 1, 33, '2022-07-06', '2022-07-23'),
	(6, 1, 2, '2022-07-13', '2022-07-30'),
	(7, 1, 22, '2022-07-08', '2022-07-30'),
	(8, 1, 3, '2022-07-07', '2022-07-29'),
	(9, 1, 10, '2022-07-06', '2022-07-30'),
	(10, 1, 22, '2022-07-20', '2022-07-30'),
	(11, 3, 4, '2022-07-13', '2022-07-15');

-- Dumping data for table foodshop.food_storage_manage: ~9 rows (approximately)
INSERT INTO `food_storage_manage` (`food_storage_manage_id`, `food_item_id`, `qty`, `mfd`, `exp`) VALUES
	(1, 1, 12, '2022-07-07', '2022-07-09'),
	(2, 1, 2, '2022-07-07', '2022-07-16'),
	(3, 1, 4, '2022-07-13', '2022-07-21'),
	(4, 1, 3, '2022-07-08', '2022-07-16'),
	(5, 1, 33, '2022-07-06', '2022-07-23'),
	(6, 1, 2, '2022-07-13', '2022-07-30'),
	(7, 1, 22, '2022-07-08', '2022-07-30'),
	(8, 1, 3, '2022-07-07', '2022-07-29'),
	(9, 1, 10, '2022-07-06', '2022-07-30'),
	(10, 1, 22, '2022-07-20', '2022-07-30'),
	(11, 3, 4, '2022-07-13', '2022-07-15');

-- Dumping data for table foodshop.gender: ~2 rows (approximately)
INSERT INTO `gender` (`gender_id`, `gender_name`) VALUES
	(1, 'male'),
	(2, 'female');

-- Dumping data for table foodshop.job_status: ~0 rows (approximately)
INSERT INTO `job_status` (`job_status_id`, `job_status_name`) VALUES
	(1, 'Active');

-- Dumping data for table foodshop.mainmenu: ~10 rows (approximately)
INSERT INTO `mainmenu` (`menuItemId`, `menuItemName`, `menuItemPrice`, `menuItemDescription`, `serving_type_id`, `menu_item_category_id`) VALUES
	(4, 'Seared Ahi Tuna ', 15, 'Fine Made Fresh Tuna Ahi Dish great starter', 7, 1),
	(5, 'Cajun Shrimp Pasta', 20, ' gulf shrimp served over linguine tossed in a creamy cajun sauce • served with garlic bread ', 7, 1),
	(6, 'Blackened Shrimp', 20, ' shrimp blackened with herbs and spices ', 7, 1),
	(7, 'Mushroom Smothered Chicken', 12, '• chicken breast smothered in a mushroom gravy', 6, 1),
	(8, 'Red Drum Pontchartrain', 25, ' blackened and topped with a creamy Cajun sauce with scallops, crawfish, crab and shrimp', 7, 1),
	(9, 'Chicken Fried Steak2', 12, ' hand breaded country fried steak, topped with homemade cream gravy', 7, 1),
	(10, 'Chicken Fried Chicken', 2, 'hand breaded chicken breast, topped with homemade cream gravy', 3, 1),
	(11, 'Jasmine Rice', 4, 'with Garlic Mashed Potatoes and Steak Fries and Macaroni & Cheese  and Hushpuppie', 7, 1),
	(12, 'Garlic Mashed Potatoes • Steak Fries • Macaroni & Cheese • Hushpuppie', 16, '8 in $6.99 16 in $12.99 ', 3, 1),
	(13, 'Bread Puddin', 11, 'pudding break', 5, 1),
	(14, 'Chicken Caesar Salad', 10, 'with Grilled or Blackened Chicken', 6, 2);

-- Dumping data for table foodshop.manager: ~0 rows (approximately)
INSERT INTO `manager` (`manager_id`, `employee_id`, `manager_type_id`) VALUES
	(1, 2, 3);

-- Dumping data for table foodshop.manager_type: ~4 rows (approximately)
INSERT INTO `manager_type` (`manager_type_id`, `manager_type_name`) VALUES
	(1, 'General Manager'),
	(2, 'Assistant Manager'),
	(3, 'Kitchen Manager'),
	(4, 'Food & Beverage Manager');

-- Dumping data for table foodshop.menu_item_category: ~0 rows (approximately)
INSERT INTO `menu_item_category` (`menu_item_category_id`, `menu_item_category_name`) VALUES
	(1, 'starters'),
	(2, 'soups&salads');

-- Dumping data for table foodshop.order_status: ~0 rows (approximately)
INSERT INTO `order_status` (`order_status_id`, `order_status_name`) VALUES
	(1, 'active '),
	(2, 'delivered'),
	(3, 'closed');

-- Dumping data for table foodshop.payment_item: ~0 rows (approximately)
INSERT INTO `payment_item` (`payment_item_id`, `qty`, `price`, `payment_note_id`, `menuItemId`) VALUES
	(9, '3', '11.0', 6, 13),
	(10, '3', '10.0', 6, 14),
	(11, '4', '11.0', 7, 13),
	(12, '4', '11.0', 8, 13),
	(13, '5', '20.0', 9, 5),
	(14, '3', '25.0', 10, 8),
	(15, '3', '15.0', 10, 4),
	(16, '1', '20.0', 11, 6),
	(17, '4', '10.0', 11, 14),
	(18, '2', '16.0', 11, 12),
	(19, '1', '12.0', 11, 7),
	(20, '1', '15.0', 11, 4);

-- Dumping data for table foodshop.payment_method: ~2 rows (approximately)
INSERT INTO `payment_method` (`payment_method_id`, `payment_method_name`) VALUES
	(1, 'Card'),
	(2, 'Cash');

-- Dumping data for table foodshop.payment_note: ~0 rows (approximately)
INSERT INTO `payment_note` (`payment_note_id`, `payment_time`, `total`, `unique_id`) VALUES
	(5, '2022-07-17 22:24:12', 63, '092a014c-9b61-4ab1-bb99-f105d89605b81658076852184'),
	(6, '2022-07-17 22:33:50', 63, '7dbd420f-2db7-49a3-93bf-3bd06de0d69b1658077430402'),
	(7, '2022-07-17 23:11:43', 44, 'b091158b-cb38-4981-86f1-08375d7515831658079703553'),
	(8, '2022-07-17 23:12:14', 44, '6e2fa6b8-8a9a-41a9-94a6-291a88ea70331658079734782'),
	(9, '2022-07-17 23:12:28', 100, 'a8f81f75-7bdf-4f4e-bf60-b6273da98bc51658079748053'),
	(10, '2022-07-17 23:12:48', 120, 'fc03b615-3137-4952-ba04-2aafb27af1461658079768493'),
	(11, '2022-07-18 00:06:37', 119, 'a1021253-395e-4f68-bc67-2d22d8ca0aee1658082997621');

-- Dumping data for table foodshop.server: ~2 rows (approximately)
INSERT INTO `server` (`server_id`, `server_type_id`, `employee_id`) VALUES
	(1, 1, 5),
	(2, 2, 8);

-- Dumping data for table foodshop.server_type: ~2 rows (approximately)
INSERT INTO `server_type` (`server_type_id`, `server_type_name`) VALUES
	(1, 'Busser'),
	(2, 'Food Runner'),
	(3, 'Expeditor');

-- Dumping data for table foodshop.serving_type: ~6 rows (approximately)
INSERT INTO `serving_type` (`serving_type_id`, `serving_type_name`) VALUES
	(1, 'Spoon'),
	(2, 'Whole'),
	(3, 'Piece'),
	(4, 'Kg'),
	(5, 'Cup'),
	(6, 'Bowl'),
	(7, 'dish');

-- Dumping data for table foodshop.supplier: ~0 rows (approximately)
INSERT INTO `supplier` (`supplier_id`, `supplier_name`, `supplier_contact`, `dealer_id`) VALUES
	(1, 'Wicky', '0782222596', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
