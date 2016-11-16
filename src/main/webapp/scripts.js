function getData() {
	$.ajax({
		url: "http://localhost:8080/rest/api/phones",
		type: "GET",
		dataType: "json",
		success: function(data) {
			console.log(data);
			$.each(data, function(index){
				var tr = $('<tr>');
				tr.append('<td>' + data[index].id +'</td>');
				tr.append('<td>' + data[index].manufacturer + '</td>');
				tr.append('<td>' + data[index].model + '</td>');
				tr.append('<td>' + data[index].cameraMP + '</td>');
				tr.append('<td>' + data[index].procesorGHz + '</td>');
				tr.append('<td>' + data[index].year + '</td>');
				tr.append('<td>' + data[index].memoryRam + '</td>');
				tr.append('</tr>');
				$('#phonesTable').append(tr);
			});
		}
	});
}

$(document).ready(function() {
	getData();
	
	$('#new-phone-form').submit(function(e) {
		e.preventDefault();
		
		var data = {
			manufacturer: $('#new-phone-manufacturer').val(),
			model: $('#new-phone-model').val(),
			cameraMP: $('#new-phone-cameraMP').val(),
			procesorGHz: $('#new-phone-procesorGHz').val(),
			year: $('#new-phone-year').val(),
			memoryRam: $('#new-phone-memoryRam').val()
		}
		
		$.ajax({
			method: 'POST',
			data: JSON.stringify(data),
			url: 'api/phones',
			contentType: 'application/json'
		});
	
		document.getElementById("new-phone-manufacturer").value = "";
	    document.getElementById("new-phone-model").value = "";
	    document.getElementById("new-phone-cameraMP").value = "";
	    document.getElementById("new-phone-procesorGHz").value = "";
	    document.getElementById("new-phone-year").value = "";
	    document.getElementById("new-phone-memoryRam").value = "";
	});
});