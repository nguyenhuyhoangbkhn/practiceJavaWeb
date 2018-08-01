$(document).ready(function() {
	$('#myDatatable').DataTable({
		"jQueryUI" : true,
		"pagingType" : "full_numbers",
		"lengthMenu" : [ [ 5, 10, 50, -1 ], [ 5, 10, 50, "All" ] ]
	/* few more options are available to use */
	});
});
