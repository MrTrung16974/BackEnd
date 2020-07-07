package com.example.backendkyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BackendkycApplication{
//        implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BackendkycApplication.class, args);
    }

//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    RoleRepository roleRepository;
//    @Autowired
//    FunctionRepository functionRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;
//    @Override
//    public void run(String... args) throws Exception {

//        User user = new User();
//        user.setUserName("trung123");
//        user.setPassword(passwordEncoder.encode("123456"));
//        user.setEmail("admin@gmail.com");
//        user.setRoleID("USER");
//        user.setStatus(1);
//
//        Role role = new Role();
//        role.setRoleID("USER");
//        role.setDescription("Khách hàng bình thường");
//        role.setRoleCode("USER_01");
//        Function function = new Function();
//        function.setId("VIEW");
//        function.setName("Xem chi tiết");
//        Function function2 = new Function();
//        function2.setId("EDIT");
//        function2.setName("Sửa chi tiết");
//        Set<Function> setFunc = new HashSet<>();
//        setFunc.add(function);
//        setFunc.add(function2);
//        role.setFunctions(setFunc);
//        roleRepository.save(role);
//        userRepository.save(user);
//        functionRepository.save(function);
//        functionRepository.save(function2);

//        Function function = new Function();
//        function.setDescription("Quyền chỉnh sửa tất cả");
//        function.setFunctionCode("SYS_ABC");
//        function.setStatus(1);
//
//        Function function2 = new Function();
//        function2.setDescription("Quyền đọc tất cả");
//        function2.setFunctionCode("SYS_DEF");
//        function2.setStatus(1);
//
//        Role role = new Role();
//        role.setDescription("User is the best");
//        role.setRoleCode("USER");
//        role.setStatus(1);
//        role.setFunctions(Arrays.asList(function,function2).stream().collect(Collectors.toSet()));
//        session.save(role);
//    }
}
