# 使用maven管理项目

个人感受:

> 对于一个完整的项目来说，项目库的依赖管理是很麻烦的，而且往往依赖包还存在依赖。之前的linux就是如此，安装好一个软件或许要手动安装一系列依赖包。这样的话，不仅降低了工作的效率而且容易出错。现在linux可以通过在线下载软件，自动寻找依赖并下载。centos通过yum命令，ubuntu通过apt命令，从仓库中下载所有的依赖。go和java也是类似的一个原理,go使用github作为中央仓库，用户可以发布自己的造的轮子到github上.maven是属于apache的一个项目,用户也可以将自己造的轮子发布在maven的中央仓库上.
>
> go语言自从推出go module之后,项目的版本和依赖问题得到了很好的解决,并且go自有的那一套工具如go build ,go test, go install用起来也是相当的丝滑。
>
> java可以通过maven去创建一个标准的项目工程，并且使用maven可以很好的解决项目的依赖问题而不用手动去添加classpath.通过maven install等命令,可以进行编译测试生成可执行的jar包便于部署等。
>
> java前段时间一直停滞在初级阶段，或许是习惯了golang的那一套流程，真的是大道至简，从而感觉到java的繁琐。直到接触了maven之后,发现这个项目构建工具太棒了，也越来越感觉到java的强大。

## 什么是maven？

Maven是专门为Java项目打造的管理和构建工具,提供了一个标准化的构建流程(编译，测试，打包，发布等)。它提供了一套依赖管理机制，类似go中的go module.

## 安装maven

[maven官网](https://maven.apache.org/download.cgi)

下载编译好的文件，并将maven目录下的bin添加到环境变量(linux环境)

```shell
export PATH="/path/apache-maven-xxx/bin:$PATH" 
```

## 修改maven镜像源

在maven的安装目录中修改conf/settings.xml

在mirrors标签中添加mirror标签,使用阿里的镜像源

```xml
<mirror>
         <id>nexus-aliyun</id>
        <mirrorOf>central</mirrorOf>
         <name>Nexus aliyun</name>
         <url>http://maven.aliyun.com/nexus/content/groups/public</url>
</mirror>
```

## maven快速入门

```shell
mvn archetype:generate "-DgroupId=com.nj_jay.helloworld" "-DartifactId=HelloWorld" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DinteractiveMode=false"
```

> 参数说明:
>
> - **-DgourpId**: 组织名，公司网址的反写 + 项目名称
> - **-DartifactId**: 项目名-模块名
> - **-DarchetypeArtifactId**: 指定 ArchetypeId，maven-archetype-quickstart，创建一个简单的 Java 应用
> - **-DinteractiveMode**: 是否使用交互模式

生成的项目结构

<img src="https://picture.nj-jay.com/maven-1.png" style="zoom:67%;" />

最重要的一个文件便是pom.xml这个描述文件了.

maven工程由`groupId`，`artifactId`和`version`作为唯一标识

dependency作为引入第三方库的依赖

### 在pom.xml中引入插件

为了编译一个可执行的jar文件，还需引入插件.使用maven-shade-plugin

```xml
<build>
    <finalName>hello</finalName>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <version>3.2.1</version>
        <executions>
          <execution>
            <phase>package</phase>
            <goals>
              <goal>shade</goal>
            </goals>
            <configuration>
              <transformers>
                <transformer           implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                  <mainClass>com.nj_jay.helloworld.App</mainClass>
                </transformer>
              </transformers>
            </configuration>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>

```

configuration标签中的内容填写java程序的入口

finalName便签可以指定生成的jar可执行文件的名字,如hello.jar

### 使用mvn

* 测试 mvn test

  > 不生成jar二进制文件,对test文件进行测试
  >
  > <img src="https://picture.nj-jay.com/maven-test.png" style="zoom:67%;" />

* 编译 mvn clean compile

  > 先clean再对main下的文件进行编译，也不生成二进制jar文件
  >
  > <img src="https://picture.nj-jay.com/maven-compile.png" style="zoom:67%;" />

* 打包mvn clean package or mvn install

  > (生成jar可执行文件,必须要添加前面的插件)
  >
  > 可以看到target目录有一个hello.jar
  >
  > 使用`java -jar target/hello.jar`即可运行该程序
  >
  > 同样的，只要把该jar文件部署到服务器即可(服务器必须有java环境)
  >
  > <img src="https://picture.nj-jay.com/maven-package.png" style="zoom:67%;" />

## 了解更多

请关注廖雪峰大神的java教程

[maven教程](https://www.liaoxuefeng.com/wiki/1252599548343744/1255945359327200)