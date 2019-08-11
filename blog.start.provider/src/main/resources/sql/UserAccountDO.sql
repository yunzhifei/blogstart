-- auto Generated on 2019-08-05 22:53:16 
-- DROP TABLE IF EXISTS `user_account_d_o`; 
CREATE TABLE user_account
(
    `id`       INTEGER(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`     VARCHAR(50)          NOT NULL DEFAULT '' COMMENT 'name',
    `pwd`      VARCHAR(50)          NOT NULL DEFAULT '' COMMENT 'pwd',
    `salt`     VARCHAR(50)          NOT NULL DEFAULT '' COMMENT 'salt',
    `status`   INTEGER(12)          NOT NULL DEFAULT -1 COMMENT 'status',
    `created`  DATETIME             NOT NULL DEFAULT current_timestamp,
    `modified` DATETIME             NOT NULL DEFAULT current_timestamp COMMENT 'modified' ON UPDATE current_timestamp,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user_account';


