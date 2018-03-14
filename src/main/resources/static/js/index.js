/**
 * Created by caiyl on 2017/10/8.
 */
$(function () {
    isLogin();

});


/**
 * 判断用户是否已经登录
 */
function isLogin() {
    $.get('/login/loginState',function (dat) {
        if (dat) {//已经登录
            console.log("已登录登录");
            $("#userInfo").html("用户："+dat.userName);
        }else{
            console.log("没登录");
            window.location.href='loginIn.html';
        }
    })
}

/**
 * 注销
 */
function loginOut() {
    $.get('/login/loginOut',function (dat) {
        if (dat) {//已经注销
            console.log("已登录登录");
            window.location.href='loginOut.html';
        }else{
            console.log("注销失败");

        }
    })
}
