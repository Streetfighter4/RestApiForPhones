var currPage = 1;
var sentRequest = false;

function getData(arg) {
	$.ajax({
		url: "http://localhost:8080/rest/api/phones",
		type: "GET",
		dataType: "json",
		data: arg,
		success: function(data) {
			if (arg.newPage == undefined) {
				$("#phones-table-body tr").remove();
			} else {
				currPage = arg.newPage+1; 
			}
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
				$('#phones-table-body').append(tr);
			});
			sentRequest = false;
		}
	});
}

$(document).ready(function() {
	var indexPage = {
		numberElement: 15,
		newPage: currPage
	};
	getData(indexPage);
	
	
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
	
	$('#filter-phone-form').submit(function(e) {
		e.preventDefault();
		
		var data = {
				manufacturerFilter: $('#filter-phone-manufacturer').val(),
				modelFilter: $('#filter-phone-model').val(),
				cameraMPFilter: $('#filter-phone-cameraMP').val(),
				procesorGHzFilter: $('#filter-phone-procesorGHz').val(),
				yearFilter: $('#filter-phone-year').val(),
				memoryRamFilter: $('#filter-phone-memoryRam').val(),
				newPage: 1,
				numberElement: 15
		};	
		$("#phones-table-body tr").remove();
		if (!sentRequest) {
			currPage = 1;
			getData(data);
			sentRequest = true;
		}
	});
	
	$(window).scroll(function() {
		if ($(window).scrollTop() + $(window).height() >= $('body').height()) {
			var indexPage = {
					manufacturerFilter: $('#filter-phone-manufacturer').val(),
					modelFilter: $('#filter-phone-model').val(),
					cameraMPFilter: $('#filter-phone-cameraMP').val(),
					procesorGHzFilter: $('#filter-phone-procesorGHz').val(),
					yearFilter: $('#filter-phone-year').val(),
					memoryRamFilter: $('#filter-phone-memoryRam').val(),
					numberElement: 15,
					newPage: currPage
			};
			if (!sentRequest) {
				getData(indexPage);
				sentRequest = true;
			}
		}
	})
});