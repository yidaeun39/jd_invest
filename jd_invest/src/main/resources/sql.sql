CREATE TABLE `bankaccount` (
	`account_number` VARCHAR(50) NOT NULL,
	`member_id` VARCHAR(50) NOT NULL DEFAULT '',
	`account_name` VARCHAR(50) NOT NULL,
	`account_ deposit` INT(10) NULL DEFAULT NULL,
	`account_branch` VARCHAR(50) NOT NULL,
	`account_manager` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`account_number`, `member_id`),
	INDEX `FK__customer` (`member_id`),
	CONSTRAINT `FK__customer` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `management` (
	`branch_code` VARCHAR(100) NOT NULL DEFAULT '',
	`branch_name` VARCHAR(100) NOT NULL,
	`barnch_manager` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`branch_code`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `member` (
	`member_id` VARCHAR(50) NOT NULL DEFAULT '',
	`member_pw` VARCHAR(50) NOT NULL,
	`member_name` VARCHAR(50) NOT NULL,
	`member_address` VARCHAR(50) NULL DEFAULT NULL,
	`member_phone` VARCHAR(50) NULL DEFAULT NULL,
	`branch_code` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`member_id`),
	INDEX `FK_customer_management` (`branch_code`),
	CONSTRAINT `FK_customer_management` FOREIGN KEY (`branch_code`) REFERENCES `management` (`branch_code`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `order` (
	`order_date` DATE NOT NULL,
	`order_number` VARCHAR(50) NOT NULL,
	`account_number` VARCHAR(50) NOT NULL DEFAULT '',
	`member_id` VARCHAR(50) NOT NULL DEFAULT '',
	`order_code` VARCHAR(50) NULL DEFAULT NULL,
	`order_amount` INT(11) NULL DEFAULT NULL,
	`order_price` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`order_date`, `order_number`, `account_number`, `member_id`),
	INDEX `FK__member` (`account_number`),
	INDEX `FK_order_member` (`member_id`),
	CONSTRAINT `FK_order_member` FOREIGN KEY (`member_id`) REFERENCES `bankaccount` (`member_id`),
	CONSTRAINT `FK__member` FOREIGN KEY (`account_number`) REFERENCES `bankaccount` (`account_number`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;


======================================================================================


INSERT INTO `management` (`branch_code`, `branch_name`, `barnch_manager`) VALUES
	('b001', '서신점', '이다은'),
	('b002', '호성점', '유지수'),
	('b003', '봉동점', '이형렬'),
	('b004', '부산점', '박성환');


INSERT INTO `member` (`member_id`, `member_pw`, `member_name`, `member_address`, `member_phone`, `branch_code`)
	VALUES ('admin', '1234', '관리자', '전주시덕진구', '010-2311-1124', 'b004')