GIT使用：
		http://www.liaoxuefeng.com/
		
	git常用命令
		创建版本库
		$ mkdir filename 	//创建文件
		$ cd filename 		//打开文件
		$ pwd		//显示当前目录
		
		$ git init	//把当前目录转换为GIT可以管理的仓库
		$ git add readme.txt //添加readme.txt文件到工作区
		$ git commit -m "wrote a readme file"	//-m后面输入的是本次提交的说明
		
		$ git status	//查看仓库当前的状态
		
		$ git diff readme.txt 	//查看readme.txt文件做了什么修改
		
		$ git log	//git log命令显示从最近到最远的提交日志
		$ git log --pretty=oneline	//简单的打印log信息（常用）
		$ git log --graph --pretty=oneline --abbrev-commit	//查看分支的合并情况
		
		$ git reset --hard HEAD^	//回退到上一个版本
		$ git reset --hard 3628164	//3628164是commit id可以通过log获得，表示回退到该版本
		$ git reflog	用来记录你的每一次命令，可以打印出你最近操作，以及commit id
		
		$ cat readme.txt	//cat查看文件内容
		
		$ git checkout -- readme.txt	//撤销修改复原文件
		$ git reset HEAD readme.txt		//add 后没commit 的撤销;commit后的要版本回退
		
		$ git rm test.txt				//删除文件，回退用$ git checkout -- readme.txt
		
		$ ssh-keygen -t rsa -C "youremail@example.com"  //在主目录（个人目录/zhou）创建ssh加密文件.ssh(隐藏文件)，目录下有id_rsa和id_rsa.pub这两个文件
														//id_rsa是私钥，不能泄露出去，id_rsa.pub是公钥，可以放心地告诉任何人
		$ git remote add origin git@github.com:MMsmileNN/learngit.git		//关联远程git仓库，
		$ git push -u origin master			//把本地库的所有内容推送到远程库上 第一次推送要加 -u
		
		$ git clone git@github.com:MMsmileNN/gitskills.git	//克隆数据从远程仓库
		
		$ git checkout -b dev	//创建dev分支，并切换到dev分支：
		$ git branch dev		//创建dev分支
		$ git checkout dev		//切换到dev
		$ git branch			//查看当前分支*表示目前所在分支
		
		$ git merge dev			//在master分支下调用该命令表示把dev合并到master分支上（快速合并，会丢掉分支信息）
		$ git merge --no-ff -m "merge with no-ff" dev		//--no-ff参数，表示禁用Fast forward ，-m 表示写描述
		$ git branch -d dev		//删除dev分支	-D 表示强制删除
		
		$ git stash	 	//存储当前工程（当有bug要及时解决但是手头工作没完成 ，相当于存档等会再做）
		$ git stash list 	//查看存储的内容
		$ git stash pop		//恢复的同时把stash内容也删了(相当于git stash apply恢复和git stash drop删除)
		
		$ git remote		//查看远程库信息
		$ git remote -v		//查看详细信息
		$ git push origin master	//推送信息到主分支
		$ git checkout -b dev origin/dev	//从远程库的dev分支到本地
		
		$ git tag v1.0		//创建标签
		$ git tag			//查看标签
		$ git tag v0.9 6224937	//根据commit id  创建标签
		$ git show v0.9		//显示标签信息
		$ git tag -d v0.1	//删除标签
		$ git push origin v1.0	//推送标签v1.0到远程库
		$ git push origin --tags	//一次性推送所有的标签到远程库
		$ git push origin :refs/tags/v0.9	//远程库中删除标签
		
		在Git工作区的根目录下创建一个特殊的.gitignore文件，然后把要忽略的文件名填进去，Git就会自动忽略这些文件（忽略文件的提交）
		当文件被忽略了  添加的时候是不让添加的我们可以通过$ git add -f App.class强制添加
		
		$ git config --global alias.co checkout		//设置co为checkout别名
		$ git config --global alias.ci commit		//设置ci为commit别名
		$ git config --global alias.br branch		//设置br为branch别名
		git config --global alias.lg "log --color --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset' --abbrev-commit"
		//设置打印log的别名为lg
		配置文件在用户主目录下的一个隐藏文件.gitconfig中
		
		
	
  GIT命令：
	查看、添加、提交、删除、找回，重置修改文件

		git help <command> # 显示command的help

		git show # 显示某次提交的内容 git show $id

		git co -- <file> # 抛弃工作区修改

		git co . # 抛弃工作区修改

		git add <file> # 将工作文件修改提交到本地暂存区

		git add . # 将所有修改过的工作文件提交暂存区

		git rm <file> # 从版本库中删除文件

		git rm <file> --cached # 从版本库中删除文件，但不删除文件

		git reset <file> # 从暂存区恢复到工作文件

		git reset -- . # 从暂存区恢复到工作文件

		git reset --hard # 恢复最近一次提交过的状态，即放弃上次提交后的所有本次修改

		git ci <file> git ci . git ci -a # 将git add, git rm和git ci等操作都合并在一起做　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　git ci -am "some comments"

		git ci --amend # 修改最后一次提交记录

		git revert <$id> # 恢复某次提交的状态，恢复动作本身也创建次提交对象

		git revert HEAD # 恢复最后一次提交的状态

	查看文件diff

		git diff <file> # 比较当前文件和暂存区文件差异 git diff

		git diff <id1><id1><id2> # 比较两次提交之间的差异

		git diff <branch1>..<branch2> # 在两个分支之间比较

		git diff --staged # 比较暂存区和版本库差异

		git diff --cached # 比较暂存区和版本库差异

		git diff --stat # 仅仅比较统计信息
	
	查看提交记录

		git log git log <file> # 查看该文件每次提交记录

		git log -p <file> # 查看每次详细修改内容的diff

		git log -p -2 # 查看最近两次详细修改内容的diff

		git log --stat #查看提交统计信息

	tig

		Mac上可以使用tig代替diff和log，brew install tig

	Git 本地分支管理

		查看、切换、创建和删除分支

			git br -r # 查看远程分支

			git br <new_branch> # 创建新的分支

			git br -v # 查看各个分支最后提交信息

			git br --merged # 查看已经被合并到当前分支的分支

			git br --no-merged # 查看尚未被合并到当前分支的分支

			git co <branch> # 切换到某个分支

			git co -b <new_branch> # 创建新的分支，并且切换过去

			git co -b <new_branch> <branch> # 基于branch创建新的new_branch

			git co $id # 把某次历史提交记录checkout出来，但无分支信息，切换到其他分支会自动删除

			git co $id -b <new_branch> # 把某次历史提交记录checkout出来，创建成一个分支

			git br -d <branch> # 删除某个分支

			git br -D <branch> # 强制删除某个分支 (未被合并的分支被删除的时候需要强制)

		分支合并和rebase

			git merge <branch> # 将branch分支合并到当前分支

			git merge origin/master --no-ff # 不要Fast-Foward合并，这样可以生成merge提交

			git rebase master <branch> # 将master rebase到branch，相当于： git co <branch> && git rebase master && git co master && git merge <branch>

		Git补丁管理(方便在多台机器上开发同步时用)

			git diff > ../sync.patch # 生成补丁

			git apply ../sync.patch # 打补丁

			git apply --check ../sync.patch #测试补丁能否成功

		Git暂存管理

			git stash # 暂存

			git stash list # 列所有stash

			git stash apply # 恢复暂存的内容

			git stash drop # 删除暂存区

		Git远程分支管理

			git pull # 抓取远程仓库所有分支更新并合并到本地

			git pull --no-ff # 抓取远程仓库所有分支更新并合并到本地，不要快进合并

			git fetch origin # 抓取远程仓库更新

			git merge origin/master # 将远程主分支合并到本地当前分支

			git co --track origin/branch # 跟踪某个远程分支创建相应的本地分支

			git co -b <local_branch> origin/<remote_branch> # 基于远程分支创建本地分支，功能同上

			git push # push所有分支

			git push origin master # 将本地主分支推到远程主分支

			git push -u origin master # 将本地主分支推到远程(如无远程主分支则创建，用于初始化远程仓库)

			git push origin <local_branch> # 创建远程分支， origin是远程仓库名

			git push origin <local_branch>:<remote_branch> # 创建远程分支

			git push origin :<remote_branch> #先删除本地分支(git br -d <branch>)，然后再push删除远程分支

	Git远程仓库管理

		GitHub

			git remote -v # 查看远程服务器地址和仓库名称

			git remote show origin # 查看远程服务器仓库状态

			git remote add origin git@ github:robbin/robbin_site.git # 添加远程仓库地址

			git remote set-url origin git@ github.com:robbin/robbin_site.git # 设置远程仓库地址(用于修改远程仓库地址) git remote rm <repository> # 删除远程仓库

		创建远程仓库

			git clone --bare robbin_site robbin_site.git # 用带版本的项目创建纯版本仓库

			scp -r my_project.git git@ git.csdn.net:~ # 将纯仓库上传到服务器上

			mkdir robbin_site.git && cd robbin_site.git && git --bare init # 在服务器创建纯仓库

			git remote add origin git@ github.com:robbin/robbin_site.git # 设置远程仓库地址

			git push -u origin master # 客户端首次提交

			git push -u origin develop # 首次将本地develop分支提交到远程develop分支，并且track

			git remote set-head origin master # 设置远程仓库的HEAD指向master分支

		也可以命令设置跟踪远程库和本地库

			git branch --set-upstream master origin/master

			git branch --set-upstream develop origin/develop
