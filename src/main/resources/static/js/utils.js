/**
 * Created by caiyl on 2017/10/8.
 */
var Utils = (function () {
    var publics = {};
    var privates = {};
    privates.add0 = function (m) {
        return m<10?'0'+m:m
    }

    publics.formatDate = function (time) {
        var time = new Date(time);
        var y = time.getFullYear();
        var m = time.getMonth()+1;
        var d = time.getDate();
        var h = time.getHours();
        var mm = time.getMinutes();
        var s = time.getSeconds();
        return y+'-'+ privates.add0(m)+'-'+privates.add0(d)+' '+privates.add0(h)+':'+privates.add0(mm)+':'+privates.add0(s);
    }
    return publics;
})()
