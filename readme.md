# 对话指令

基于Socket-command的指令包。  
可以通过配置文件来处理对话回应。

------

对话文件在服务端目录下的config\answer\answerMap.properties中，使用以下格式书写：

```properties
你好=你也好
你是谁=你猜
```

然后在服务端加载了此指令包后，可以通过`answer`指令使用

```shell
answer 你好
你也好
```