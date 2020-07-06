package com.ymzhao.website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ymzhao.website.mapper")
public class WebsiteApplication {

    public static void main(String[] args) {
//        codeGenerator();
        SpringApplication.run(WebsiteApplication.class, args);
    }

    /*public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }*/

    /*public static void codeGenerator() {
        //        代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //        全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("ymzhao");
        gc.setOpen(false);
        //        gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        //        数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/ymzhaodb?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC");
//        dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("zym1993");
        mpg.setDataSource(dsc);

        //        包配置
        PackageConfig pc = new PackageConfig();
        //        pc.setModuleName(scanner("模块名"));
        pc.setModuleName("website");
        pc.setParent("com.ymzhao");
        mpg.setPackageInfo(pc);

        //        自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        String templatePath = "/templates/mapper.xml.ftl";
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //                自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        //        配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        //        策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel); // 数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); // 数据库表字段映射...
        //        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true); // 生成 @RestController 控制器
        //        公共父类
        //        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        //        写于父类中的公共字段
//        strategy.setSuperEntityColumns("id"); // 自定义基础的Entity类，公共字段
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(",")); // 需要包含的表名，允许正则表达式（与exclude二选一配置
        strategy.setControllerMappingHyphenStyle(true); // 驼峰转连字符
        //        strategy.setTablePrefix(pc.getModuleName() + "_"); // 表前缀(数据库表：sts_dept需要去掉：sts_,可设"sts_")
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }*/
}
