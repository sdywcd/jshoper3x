/* 
Kriesi (http://themeforest.net/user/Kriesi)
http://www.kriesi.at/archives/create-a-multilevel-dropdown-menu-with-css-and-improve-it-via-jquery 
*/

function quick() {
    $("#quick ul ").css({ display: "none" });
    $("#quick li").hover(function () {
	$(this).find('ul:first').css({visibility: "visible",display: "none"}).show(400);
    }, function () {
        $(this).find('ul:first').css({ visibility: "hidden" });
    });
}

$(document).ready(function () {
    quick();
});