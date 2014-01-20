function MaxLengthTextarea(objettextarea,maxlength)
{
  if (objettextarea.value.length > maxlength) 
  {
    objettextarea.value = objettextarea.value.substring(0, maxlength);
    alert('Votre texte ne doit pas dépasser '+maxlength+' caractères!');
   }
}




function init() {
	if(document.getElementById("comment").value == "")
	{
	    alert("message vide!");
		
	}
	  }


$(document).ready(function() {
    $('#tousMessages').dataTable(
    		{
    			"bJQueryUI": true,
    	        "sPaginationType": "full_numbers",
    	        "aoColumnDefs": [{"bSortable": false, "aTargets": [2]}]
    	        
    	    }
    
    );
} );





