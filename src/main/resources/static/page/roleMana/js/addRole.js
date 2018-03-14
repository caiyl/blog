/**
 * Created by caiyl on 2017/10/8.
 */
function save() {
    var data = $("form").serializeArray()
    $.post('/role/',data,function (dat) {
        if (dat == 0) {
            layer.msg('保存成功', function(){
                closeLayer();
            });
        }else{
            layer.msg('保存失败');
        }
    })
}
function closeLayer() {
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
}