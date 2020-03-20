## Ali社区

## 资料
[Spring 文档](https://spring.io/guides)
[Spring Web文档](https://spring.io/guides/gs/serving-web-content/)
[Github OAuth文档](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)
[BootStrap文档](https://v3.bootcss.com/css/)
[ES社区](https://elasticsearch.cn)

## 工具
[Git](https://git-scm.com/download)
[Visual Paradigm](https://www.visual-paradigm.com)

## git命令
利用ssh可以不用输入用户名密码。详见[如何生成SSH](https://help.github.com/en/github/authenticating-to-github/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)，
[如何设置SSH到github](https://help.github.com/en/github/authenticating-to-github/adding-a-new-ssh-key-to-your-github-account)
### 提交到git缓存
```git
git add .
```
### 设置commit
```shell script
git commit -m "add readme"
```

### 追加到上一个缓存
```shell script
git commit --amend --no-edit
```
注意使用该命令前要先执行提交git缓存命令,即`git add .`
### push
```git
git push
```

## 利用Github登录

![github登录](https://www.lijingxin.top/upload/2020/3/image-2aeb9e36fe64471b81e18656c6968aed.png)

## 常用快捷键
* ctrl+shift+f12 最大化工作区
* ctrl+alt+L 格式化代码
* ctrl+shift+N 快速跳转
* ctrl+e 返回上一个编辑的页面

## 一些注意的
当调用的方法需要传递很多参数时，最好定义一个对象。

### git无法推送
https://blog.csdn.net/qq_36181310/article/details/88760623
注意一定要在bash.exe中输入ssh -T git@github.com

## Session和Cookie
Cookie相当于银行
可以再Chrome-Application-Storage-Cookies查看当前网站Cookies
Session相当于银行卡