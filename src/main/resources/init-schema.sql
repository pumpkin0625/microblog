DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `nickname` varchar(45) NOT NULL,
  `real_name` varchar(45) DEFAULT NULL,
  `password` varchar(128) NOT NULL,
  `salt` varchar(32) NOT NULL,
  `head_url` varchar(256) NOT NULL,
  `sex` enum('Male','Female') NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(32) NOT NULL,
  `address` varchar(128) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `introduction` text,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `nickname_UNIQUE` (`nickname`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `login_ticket`;
CREATE TABLE `login_ticket` (
  `login_ticket_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `ticket` varchar(45) NOT NULL,
  `expired` datetime NOT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`login_ticket_id`),
  UNIQUE KEY `ticket_UNIQUE` (`ticket`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `microblog`;
CREATE TABLE `microblog` (
  `microblog_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `content` text NOT NULL,
  `like_count` int(11) NOT NULL,
  `comment_count` int(11) NOT NULL,
  PRIMARY KEY (`microblog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `entity_id` int(11) NOT NULL,
  `entity_type` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `content` text NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`comment_id`),
  KEY `entity_index` (`entity_id`,`entity_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_id` int(11) NOT NULL,
  `receiver_id` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `content` text NOT NULL,
  `has_read` int(11) NOT NULL,
  `conversation_id` varchar(45) NOT NULL,
  PRIMARY KEY (`message_id`),
  KEY `conversation_index` (`conversation_id`),
  KEY `created_date` (`created_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `user_id` int(11) NOT NULL,
  `cared_user_id` int(11) DEFAULT NULL,
  `has_cared` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(256) NOT NULL,
  `image_server` varchar(256) NOT NULL,
  `microblog_id` int(11) NOT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


















