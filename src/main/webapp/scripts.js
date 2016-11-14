function getData() {
	$.ajax({
		url: "http://localhost:8080/rest/api/phones",
		type: "GET",
		dataType: "json",
		success: function(data) {
			console.log(data);
			$.each(data, function(index){
				var tr = $('<tr>');
				tr.append('<td>' + data[index].id + '</td>');
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
});