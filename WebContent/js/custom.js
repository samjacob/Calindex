jQuery(document).bind("gform_post_conditional_logic", function () {
    var bDate = jQuery('#input_4_2'),
        bDateEs = jQuery('#input_5_2');

    bDate.prop('readonly', 'readonly');
    bDate.datepicker('option', 'maxDate', 0 );
    bDateEs.prop('readonly', 'readonly');
    bDateEs.datepicker('option', 'maxDate', 0 );

   jQuery('#ui-datepicker-div').css('display', 'none');
    jQuery('li.gfield').each(function( index ) {
        var field = jQuery(this).find('input'),
            description = jQuery(this).find('.gfield_description')
                .not('.validation_message');
        field.focusin(function() {
            description.fadeIn(250);
        });
        field.focusout(function() {
            description.fadeOut(250);
        });
    });
});


jQuery(document).bind("gform_post_render", function () {
    // scroll to error field width -50px from top
    // so that field labels are visible
    setTimeout(function(){
        var errorFields = jQuery("li.gfield.gfield_error");
        if (errorFields.length) {
            errorFields.get(0).scrollIntoView();
        }
    }, 300);
});

jQuery(document).ready(function() {
    var bannerText = jQuery('.hero-caption h1');
    jQuery('.nav.faq-nav-tabs li').on('click', function () {
        if(jQuery(this).find('a[href=#consumer-es]').length) {
            bannerText.html('Preguntas Más Frecuentes');
        } else {
            bannerText.html('Frequently Asked Questions');
        }
    });
});

/* validation logic  starts*/
var container;
// Find required elements and add class
jQuery('.gfield_contains_required').each(function(i, e){
	jQuery(e).find('input, select, textarea').addClass('required');
});
jQuery('form').validate({
	debug: false,
	errorElement: 'div',
	errorClass: 'gfield_error',
	errorPlacement: function(error, element){
		container = element.closest('.gfield');
		error.appendTo(container);
	},
	groups: function(){
		var result = {};
		jQuery('div.ginput_complex').each(function(i,e) {
			var fieldName = e.id;
			jQuery(this).find('input, select, textarea').each(function(i,e) {
				if(result[fieldName] != undefined){
					result[fieldName] += ' '+e.name;
				} else {
					result[fieldName] = e.name
				}
			});
		});
		//console.log(result);
		return result;
	},
	highlight: function(element, errorClass, validClass) {
		jQuery(element).closest('.gfield').addClass(errorClass).removeClass(validClass);
	},
	unhighlight: function(element, errorClass, validClass) {
		jQuery(element).closest('.gfield').removeClass(errorClass).addClass(validClass);
	},
	invalidHandler: function(event, validator) {
		
	},
	submitHandler: function(form) {
		document.forms[0].action="captureData.html";
		document.forms[0].submit();
	}	
});
var getGroups = (function(){
	var result = {};
	jQuery('div.ginput_complex').each(function(i,e) {
		var fieldName = e.id;
		jQuery(this).find('input, select, textarea').each(function(i,e) {
			if(result[fieldName] != undefined){
				result[fieldName] += ' '+e.name;
			} else {
				result[fieldName] = e.name
			}
		});
	});
	//console.log(result);
	return result;
});
/* validation logic  ends*/

/* date picker logic starts*/
jQuery(document).ready(gformInitDatepicker);

function gformInitDatepicker(){
    jQuery('.datepicker').each(
        function (){
            var element = jQuery(this);
            var format = "mm/dd/yy";

            if(element.hasClass("mdy"))
                format = "mm/dd/yy";
            else if(element.hasClass("dmy"))
                format = "dd/mm/yy";
            else if(element.hasClass("dmy_dash"))
                format = "dd-mm-yy";
            else if(element.hasClass("dmy_dot"))
                format = "dd.mm.yy";
            else if(element.hasClass("ymd_slash"))
                format = "yy/mm/dd";
            else if(element.hasClass("ymd_dash"))
                format = "yy-mm-dd";
            else if(element.hasClass("ymd_dot"))
                format = "yy.mm.dd";

            var image = "";
            var showOn = "focus";
            if(element.hasClass("datepicker_with_icon")){
                showOn = "both";
                image = jQuery('#gforms_calendar_icon_' + this.id).val();
            }

            element.datepicker({ yearRange: '-100:+20', showOn: showOn, buttonImage: image, buttonImageOnly: true, dateFormat: format, changeMonth: true, changeYear: true, onSelect: function (){ element.focus(); } });
        }
    );
}

/* date picker logic ends */