//------------------------------
//navbar
//------------------------------

	//navbar scroll class
	$(document).ready(function(){
	  $(window).scroll(function(){
	  	var scroll = $(window).scrollTop();
		  if (scroll > 0) {
		    $('nav').addClass('scroll');
		  }

		  else{
			  $('nav').removeClass('scroll');	
		  }
	  })
	});

//------------------------------
//Smooth In-page navigation
//------------------------------

	$('a[href*="#"]').on('click', function(e) {
		$('html, body').animate(
			{
			    scrollTop: $($(this).attr('href')).offset().top,
			},
			500,
			'linear'
		);
	});

//------------------------------
//Projects Carousel 
//------------------------------

	$('.owl-carousel').owlCarousel({
		    loop:true,
		    center:true,
		    margin:50,
		    dots:true,
		    autoWidth:true,
		    autoplay: true,
		    smartSpeed: 1000,
		    autoplayTimeout:10000,
		    autoplayHoverPause:true,
		    responsive:{
		        0:{
		            items:1,
		            autoplay:true,
		            margin:10,
		            autoplayTimeout:5000,
		        },
		        600:{
		            items:2,
		            autoplay:true,
		            margin:30,
		            autoplayTimeout:5000,
		        },
		        1000:{
		            items:4,
		            margin:40,
		            autoplay:true,
		            autoplayTimeout:9000,
		        }
		    }
		})

//------------------------------
//Counter
//------------------------------	

			$(function () {
			  	$("#counter_up").waypoint(function (direction) {
			        if (direction === "down") {
						$(".counter").each(function () {
							var $this = $(this);
					        var counterNumber = $this.attr("data-count");
					        $({
					          couterInit: $this.text()
					        }).animate({
					          couterInit: counterNumber
					        }, {
							        duration: 3000,
							        easing: 'swing',
							        step: function () {
							            $this.text(Math.ceil(this.couterInit));
							        },
							        complete: function () {
							        	$this.text(this.counterNumbercountNum);
							        }
							    })
							    });
							    }
							  },{
							    	offset:"50%"
							    });
						});


//------------------------------
//Pre-Loader
//------------------------------

	$(window).on('load', function () {
        $('#pre_loader').fadeOut('slow');
        $('#pre_loader').css({"display":"none"});
    });






	var counter = 1;
	$(document).ready(function() {

	  var erroEle = $('.error-message'),
		focusInput = $('.questions').find('.active');

	  $('.navigation a').click(function() {
		nextMaster('navi');

		var thisInput = $('#' + $(this).attr('data-ref'));
		$('.active').removeClass('active');
		thisInput.focus().addClass('active')
		thisInput.closest('li').animate({
		  marginTop: '0px',
		  opacity: 1
		}, 200);
		thisInput.closest('li').prevAll('li').animate({
			marginTop: '-150px',
			opacity: 0
		  }, 200)
		  //                     .AddClass('done');

		thisInput.closest('li').nextAll('li').animate({
			marginTop: '150px',
			opacity: 0
		  }, 200)
		  //                    .RemoveClass('done');
		errorMessage(erroEle, '', 'hidden', 0);

	  });

	  if (focusInput.val() != '') {
		$('#next-page').css('opacity', 1);
	  }

	  $(document).keypress(function(event) {
		if (event.which == 13) {
		  nextMaster('keypress');
		  event.preventDefault();
		}

		$('#next-page').click(function() {
		  var focusInput = $('.questions').find('.active');
		  nextMaster('nextpage');

		})

	  });

	  function nextMaster(type) {
		var focusInput = $('.questions').find('.active');
		if (focusInput.val() != '') {
		  if ((focusInput.attr('name') == 'name' || focusInput.attr('name') == 'username') && focusInput.val().length < 2) {
			errorMessage(erroEle, "isn't your " + focusInput.attr('name') + " bit small. ", 'visible', 1);
		  } else if (focusInput.attr('name') == 'email' && !validateEmail(focusInput.val())) {
			errorMessage(erroEle, "It doesn't look like a " + focusInput.attr('name'), 'visible', 1);
		  } else if (focusInput.attr('name') == 'phone' && !validatePhone(focusInput.val())) {
			errorMessage(erroEle, "It doesn't look like a " + focusInput.attr('name'), 'visible', 1);
		  } else {

			if (type != 'navi') showLi(focusInput);
			$('#next-page').css('opacity', 0);
			errorMessage(erroEle, '', 'hidden', 0);
		  }
		} else if (type == 'keypress') {
		  errorMessage(erroEle, 'please enter your ' + focusInput.attr('name'), 'visible', 1);
		}

	  }

	  $("input[type='text']").keyup(function(event) {
		var focusInput = $(this);
		if (focusInput.val().length > 1) {
		  if ((focusInput.attr('name') == 'email' && !validateEmail(focusInput.val())) ||
			(focusInput.attr('name') == 'phone' && !validatePhone(focusInput.val()))) {
			$('#next-page').css('opacity', 0);
		  } else {
			$('#next-page').css('opacity', 1);
		  }

		} else {
		  $('#next-page').css('opacity', 0);
		}
	  });

	  $("#password").keyup(function(event) {
		var focusInput = $(this);
		$("#viewpswd").val(focusInput.val());
		if (focusInput.val().length > 1) {
		  $('#next-page').css('opacity', 1);
		}
	  });

	  $('#signup').click(function() {
		$('.navigation').fadeOut(400).css({
		  'display': 'none'
		});
		$('#sign-form').fadeOut(400).css({
		  'display': 'none'
		});
		$(this).fadeOut(400).css({
		  'display': 'none'
		});
		$('#wf').animate({
		  opacity: 1,
		  marginTop: '1em'
		}, 500).css({
		  'display': 'block'
		});
	  });

	  $('#show-pwd').mousedown(function() {
		$(this).toggleClass('view').toggleClass('hide');
		$('#password').css('opacity', 0);
		$('#viewpswd').css('opacity', 1);
	  }).mouseup(function() {
		$(this).toggleClass('view').toggleClass('hide');
		$('#password').css('opacity', 1);
		$('#viewpswd').css('opacity', 0);
	  });

	});

	function showLi(focusInput) {

	  focusInput.closest('li').animate({
		marginTop: '-150px',
		opacity: 0
	  }, 200);

	  console.log(focusInput.closest('li'));

	  if (focusInput.attr('id') == 'viewpswd') {
		$("[data-ref='" + focusInput.attr('id') + "']")
		  .addClass('done').html('password');
		//                    .html(Array(focusInput.val().length+1).join("*"));
	  } else {
		$("[data-ref='" + focusInput.attr('id') + "']").addClass('done').html(focusInput.val());
	  }

	  focusInput.removeClass('active');
	  counter++;

	  var nextli = focusInput.closest('li').next('li');

	  nextli.animate({
		marginTop: '0px',
		opacity: 1
	  }, 200);

	  nextli.find('input').focus().addClass('active');

	}

	function errorMessage(textmeg, appendString, visib, opaci) {
	  textmeg.css({
		visibility: visib
	  }).animate({
		opacity: opaci
	  }).html(appendString)
	}

	function validateEmail(email) {
	  var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	  return re.test(email);
	}

	function validatePhone(phone) {
	  var re = /\(?([0-9]{3})\)?([ .-]?)([0-9]{3})\2([0-9]{4})/;
	  return re.test(phone);
	}


	// For changing color of text upon reload

	// $(function(){
	// 	var themeClassName = "theme_"+Math.floor((Math.random() * 4) + 1);
	// 	$('body').addClass(themeClassName);
	// });