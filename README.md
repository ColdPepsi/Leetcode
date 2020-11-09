# Leetcode
- 敲一下`leetcode`题，不定期更新。
- 项目采用`maven`构建，关于链表和树的题目依赖`common`模块。
- `common`模块是一些基础文件，如结点的定义等等。
- 如果项目拉到本地，其他模块不识别`common`模块，代码报红的话可尝试以下思路：
    - `common`模块打包安装到本地。
    - `File->Settings->Editor->File Encodings`，文件编码统一成**UTF-8**。
    - `File->Invalidate Caches/Restart`,尝试重启。
    - 把所有`maven`模块`reimport`一下。
    - 重新生成`common.iml`文件，在`common`模块根目录终端执行`mvn idea:module`命令。

### 更新于2020-11-09
因个人原因，以后可能会更新得很慢了