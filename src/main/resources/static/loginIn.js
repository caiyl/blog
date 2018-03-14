$(function () {

});

/**
 * 发起请假申请
 */
function loginIn() {
    var data = $("form").serializeArray()
    $.post('/login/loginIn',data,function (dat) {
        if (dat == 0) {
            layer.msg('登录成功', function(){
                window.location.href='index.html';
            });
        }else{
            layer.msg('登录失败');
        }
    })
}
