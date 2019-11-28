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
		            "Su",
		            "Mo",
		            "Tu",
		            "We",
		            "Th",
		            "Fr",
		            "Sa"
		        ],
		        "monthNames": [
		            "January",
		            "February",
		            "March",
		            "April",
		            "May",
		            "June",
		            "July",
		            "August",
		            "September",
		            "October",
		            "November",
		            "December"
		        ],
		        "firstDay": 1
		    }
		  }, function(start, end, label) {
		    console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
		  });
		});
		
		
		
		
		</script>		
</html>