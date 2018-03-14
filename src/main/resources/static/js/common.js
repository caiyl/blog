/**
 * Created by caiyl on 2017/10/8.
 */
(function(){
    layui.use(['layer', 'form'], function(){
        var layer = layui.layer
            ,form = layui.form;
    window.layer = layer;
    });

    window.getUrlParam = function(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }

})()

