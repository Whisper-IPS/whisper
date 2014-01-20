<!-- Accordion JS -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script type="text/javascript">

		$(document).ready(function() {

			// Store Variables
			var accordion_tab = $('.accordion a.tab'),
				accordion_content = $('.accordion div.content');

			// When the tab is clicked function
			accordion_tab.on('click', function(e){

				// Disable tab links
				e.preventDefault();

				// Remove the active class
				accordion_tab.removeClass('active');

				// Hide the content
				accordion_content.slideUp('normal');

				// If tab is hidden open it and add the active class
				if($(this).next().is(':hidden') == true) {

					$(this).addClass('active');

					$(this).next().slideDown('normal');
				 } 
				  
			 });

			// Open the first tab on load
			accordion_tab.first().addClass('active').next().slideDown('normal');

		});

	</script>
	<!-- end Accordion JS -->