use template; 

CREATE TABLE `functions` (
                             `function_code` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
                             `description` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
                             PRIMARY KEY (`function_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `role` (
                        `id` int(11) NOT NULL,
                        `role_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `user` (
                        `id` int(11) NOT NULL,
                        `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
                        `password` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
                        `role_id` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `role_function` (
                                 `id` int(11) NOT NULL,
                                 `role_id` int(11) DEFAULT NULL,
                                 `function_id` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;