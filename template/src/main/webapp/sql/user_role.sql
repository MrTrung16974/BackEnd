CREATE TABLE `role_function` (
                                 `id` int(11) NOT NULL,
                                 `role_id` int(11) DEFAULT NULL,
                                 `function_id` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci