NutzMole 代码生成器 1.0

使用方法:
1. 将数据库驱动jar放入lib文件夹中(H2和Mysql已经内置)
2. 修改moleconf/project.properties,填入/修改相应的参数
3. 执行RunMe.bat,生成的文件位于 out/项目名/
4. 打开Eclipse或Netbeans,新建Web工程,将文件拷贝到工程即可

功能限制:
1.视图会被忽略
2.如果某个列的属性未登记的话,会被忽略 -- 可以在moleconf/type-mapping.properties定义
3.未能生成@One/@Many等注解

配置文件说明:
project.properties       项目的基本配置
type-mapping.properties  数据库表字段类型-->Java类型映射配置
table-mapping.properties 数据库表名-->Java类名映射关系
table-field-mapping.properties 数据库字段-->Java属性映射关系,使用两段式 tableName.myidXXX=id,或者*.myId=id
