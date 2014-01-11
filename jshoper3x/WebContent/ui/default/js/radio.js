jQuery(document).ready(function(){

jQuery(".niceRadio").each(
function() {     
     changeRadioStart(jQuery(this));     
});

});



function changeRadio(el)
/* 
	функция смены вида и значения radio при клике на контейнер
*/
{

	var el = el,
		input = el.find("input").eq(0);
	var nm=input.attr("name");
		
	jQuery(".niceRadio input").each(
	
	function() {
     
		if(jQuery(this).attr("name")==nm)
		{
			jQuery(this).parent().removeClass("radioChecked");
		}
	   
	   
	});					  
	
	
	if(el.attr("class").indexOf("niceRadioDisabled")==-1)
	{	
		el.addClass("radioChecked");
		input.attr("checked", true);
	}
	
    return true;
}

function changeVisualRadio(input)
{
/*
	меняем вид radio при смене значения
*/
	var wrapInput = input.parent();
	var nm=input.attr("name");
		
	jQuery(".niceRadio input").each(
	
	function() {
     
		if(jQuery(this).attr("name")==nm)
		{
			jQuery(this).parent().removeClass("radioChecked");
		}
	   
	   
	});

	if(input.attr("checked")) 
	{
		wrapInput.addClass("radioChecked");
	}
}

function changeRadioStart(el)
/* 
	новый контрол выглядит так <span class="niceRadio"><input type="radio" name="[name radio]" id="[id radio]" [checked="checked"] /></span>
	новый контрол получает теже name, id и другие атрибуты что и были у обычного
*/
{

try
{
var el = el,
	radioName = el.attr("name"),
	radioId = el.attr("id"),
	radioChecked = el.attr("checked"),
	radioDisabled = el.attr("disabled"),
	radioTab = el.attr("tabindex");
	radioValue = el.attr("value");
	if(radioChecked)
		el.after("<span class='niceRadio radioChecked'>"+
			"<input type='radio'"+
			"name='"+radioName+"'"+
			"id='"+radioId+"'"+
			"checked='"+radioChecked+"'"+
			"tabindex='"+radioTab+"'"+
            "value='"+radioValue+"' /></span>");
	else
		el.after("<span class='niceRadio'>"+
			"<input type='radio'"+
			"name='"+radioName+"'"+
			"id='"+radioId+"'"+
			"tabindex='"+radioTab+"'"+
	        "value='"+radioValue+"' /></span>");
	
	/* если контрол disabled - добавляем соответсвующий класс для нужного вида и добавляем атрибут disabled для вложенного radio */		
	if(radioDisabled)
	{
		el.next().addClass("niceRadioDisabled");
		el.next().find("input").eq(0).attr("disabled","disabled");
	}
	
	/* цепляем обработчики стилизированным radio */		
	el.next().bind("mousedown", function(e) { changeRadio(jQuery(this)) });
	el.next().find("input").eq(0).bind("change", function(e) { changeVisualRadio(jQuery(this)) });
	if(jQuery.browser.msie)
	{
		el.next().find("input").eq(0).bind("click", function(e) { changeVisualRadio(jQuery(this)) });	
	}
	el.remove();
}
catch(e)
{
	// если ошибка, ничего не делаем
}

    return true;
}

