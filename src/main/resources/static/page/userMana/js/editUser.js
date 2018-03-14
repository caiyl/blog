$(function () {
    initForm();
})
/**
 * Created by caiyl on 2017/10/8.
 */
function save() {
    var dat = $("form").serializeArray()

    $.ajax({
        url:"/user/",
        type:'put',
        dataType:"json",
        data:dat,
        success:function(result){
            layer.msg("修改成功");
        }
    })

}
function closeLayer() {
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
}

/**
 * 初始化表达数据
 */
function initForm() {
    $.get('/user/'+getUrlParam("id"),function (dat) {
        $("#id").val(dat.id);
        $("#userName").val(dat.userName);
        $("#userNameCN").val(dat.userNameCN);
        $("#password").val(dat.password);
        $("#userSex").val(dat.userSex);
    })
}