/**
 * Created by caiyl on 2017/10/8.
 */
function save() {
    var data = $("form").serializeArray()
    $.post('/models/newModel',data,function (dat) {
        if (dat.successFlag) {
            layer.msg("保存成功");

            setTimeout(function () {
                parent.layer.open({
                    type: 2,
                    title: '编辑流程',
                    shadeClose: true,
                    shade: false,
                    maxmin: true, //开启最大化最小化按钮
                    area: ['100%', '100%'],
                    offset: 't',
                    content: '/modeler.html?modelId='+dat.message
                });

                closeLayer();

            },2000)

        }
    })
}
function closeLayer() {
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
}