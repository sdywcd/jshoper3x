/* path to the stylesheets for the color picker */
var style_path = "resources/css/colors";

$(document).ready(function () {
    /* messages fade away when dismiss is clicked */
    $(".message > .dismiss > a").live("click", function (event) {
        var value = $(this).attr("href");
        var id = value.substring(value.indexOf('#') + 1);

        $("#" + id).fadeOut('slow', function () { });

        return false;
    });

    /* color picker */
    $("#colors-switcher > a").click(function () {
        var style = $("#color");

        style.attr("href", "" + style_path + "/" + $(this).attr("title").toLowerCase() + ".css");

        return false;
    });

    $("#menu h6 a").click(function () {
        var link = $(this);
        var value = link.attr("href");
        var id = value.substring(value.indexOf('#') + 1);

        var heading = $("#h-menu-" + id);
        var list = $("#menu-" + id);

        if (list.attr("class") == "closed") {
            heading.attr("class", "selected");
            list.attr("class", "opened");
        } else {
            heading.attr("class", "");
            list.attr("class", "closed");
        }
    });

    $("#menu li[class~=collapsible]").click(function () {
        var element = $(this);

        element.children("a:first-child").each(function () {
            var child = $(this);

            if (child.attr("class") == "plus") {
                child.attr("class", "minus");
            } else {
                child.attr("class", "plus");
            }
        });

        element.children("ul").each(function () {
            var child = $(this);

            if (child.attr("class") == "collapsed") {
                child.attr("class", "expanded");
            } else {
                child.attr("class", "collapsed");
            }
        });
    });
});