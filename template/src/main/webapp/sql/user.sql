CREATE TABLE `user` (
                        `id` int(11) NOT NULL,
                        `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
                        `password` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
                        `role_id` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci