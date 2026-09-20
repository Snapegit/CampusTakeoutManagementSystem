const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm0251958k/",
            name: "ssm0251958k",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm0251958k/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于SSM框架的校园外卖管理系统的设计与实现"
        } 
    }
}
export default base
