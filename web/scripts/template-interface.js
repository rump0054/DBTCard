$(document).ready(function() {
        $.getJSON('template.targets.ajax.logic', function(data) {
            $.each(data, function(index, entry) {
                
            })
        }
        
    });
    
    /*$('#defined li').draggable({
        appendTo: 'body',
        helper: 'clone'
    });
    
    $('#feelings ul').droppable({
       activeClass: 'ui-state-default',
       hoverClass: 'ui-state-hover',
       accept: '.drag-feeling',
       drop: function(event, ui) {
           $(this).find('.placeholder').remove();
           $('<li></li>').text(ui.draggable.text()).appendTo(this);
       }
    }).sortable({
        items: "li:not(.placeholder)",
        sort: function() {
            $(this).removeClass('ui-state-default');
        }
    });
    
    $('#thoughts ul').droppable({
       activeClass: 'ui-state-default',
       hoverClass: 'ui-state-hover',
       accept: '.drag-thought',
       drop: function(event, ui) {
           $(this).find('.placeholder').remove();
           $('<li></li>').text(ui.draggable.text()).appendTo(this);
       }
    }).sortable({
        items: "li:not(.placeholder)",
        sort: function() {
            $(this).removeClass('ui-state-default');
        }
    });
    
    $('#behaviors ul').droppable({
       activeClass: 'ui-state-default',
       hoverClass: 'ui-state-hover',
       accept: '.drag-behavior',
       drop: function(event, ui) {
           $(this).find('.placeholder').remove();
           $('<li></li>').text(ui.draggable.text()).appendTo(this);
       }
    }).sortable({
        items: "li:not(.placeholder)",
        sort: function() {
            $(this).removeClass('ui-state-default');
        }
    });*/
});