$(document).ready(function() {
    $('#accordion').accordion({
        autoHeight: false,
        navigation: true,
        collapsible: true
    });

    $('a[name=modal]').click(function(e) {
        e.preventDefault();
        
        var id = $(this).attr('href');
        var category = $(this).attr('id');
        
        //Screen height and width
        var maskHeight = $(document).height();
        var maskWidth = $(window).width();
        
        //Set height and width of the mask to full screen
        $('#mask').css({'width':maskWidth, 'height':maskHeight});
        
        //Transaction effect
        $('#mask').show();
        
        //Get height and width of window
        var winH = $(window).height();
        var winW = $(window).width();
        
        //Center the popup in window
        $(id).css('top', winH/2-$(id).height()/2);
        $(id).css('left', winW/2-$(id).width()/2);
        
        //Set the category ID
        $('#catID').val(category);
        
        //show popup
        $(id).show();
    });
    
    //Cancel button on dialog box
    $('.window .close').click(function(e) {
        e.preventDefault();
        
        $('#mask').hide();
        $('.window').hide();
    });
    
    //If mask area is clicked
    $('#mask').click(function() {
        $(this).hide();
        $('.window').hide();
    });
    
    //Cancel button on dialog box
    $('.window .add').click(function(e) {
        e.preventDefault();
        
        var url = 'target.addtarget.ajax.logic';
        var inp = 'cID=' + $('#catID').val() + "&";
        inp += 'targetName=' + $('#targName').val() + "&";
        inp += 'targetDesc=' + $('#targDesc').val() + "&";
        inp += 'range=' + $('input:radio[name=rangeMax]:checked').val();
        
        $.ajax({
           type: "GET",
           url: url,
           data: inp,
           success: function(data){
               var rowText = '<tr><td>' + data.target.target + '</td>';
               rowText += '<td align="right"><input type="checkbox" name="id" ';
               rowText += 'value="' + data.target.targetID + '" checked="checked"/></td></tr>';
               
               if(data.target.categoryID == 7)//t and B
               {
                   $('#tblF').append(rowText);
               }
               else if(data.target.categoryID == 6)
               {
                   $('#tblT').append(rowText);
               }
               else if(data.target.categoryID == 5)
               {
                   $('#tblB').append(rowText);
               }
           }
        });

        //Reset the form fields to defaults
        $('#catID').val('');
        $('#targName').val('');
        $('#targDesc').val('');
        $('input:radio[name=rangeMax]:checked').removeAttr('checked');
        
        //Hide the pop up stuff
        $('#mask').hide();
        $('.window').hide();
    });
});