CREATE TABLE `functions` (
                             `function_code` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
                             `description` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
                             PRIMARY KEY (`function_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci