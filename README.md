## Ali社区

## 资料
https://spring.io/guides

## 工具
https://git-scm.com/download

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
