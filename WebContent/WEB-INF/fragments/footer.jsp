	</body>
	
		<!-- Bootstrap core JavaScript -->
		
		<script>
		


		$(document).ready(function() {
		    $('#signInForm').bootstrapValidator();
		});


		
		$(function() {
		  $('input[name="daterange"]').daterangepicker({
		    opens: 'left',
		    	 "locale": {
				        "format": "DD/MM/YYYY",
				        "separator": " - ",
				        "applyLabel": "Apply",
				        "cancelLabel": "Cancel",
				        "fromLabel": "From",
				        "toLabel": "To",
				        "customRangeLabel": "Custom",
				        "weekLabel": "W",
				        "daysOfWeek": [
				            "Dim",
				            "Lun",
				            "Mar",
				            "Mer",
				            "Jeu",
				            "Ven",
				            "Sa"
				        ],
				        "monthNames": [
				            "Janvier",
				            "F�vrier",
				            "Mars",
				            "Avril",
				            "Mai",
				            "Juin",
				            "Juillet",
				            "Ao�t",
				            "Septembre",
				            "Octobre",
				            "Novembre",
				            "Decembre"
				        ],
				        "firstDay": 7
				    }
		  }, function(start, end, label) {
		    console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
		  });
		});
		
		
		
		
		</script>		
</html>