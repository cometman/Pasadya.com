/*globals jQuery */
/* ***********************************************************************************

	CJ Image Flip Box JavaScript framework

	Copyright (c) 2009, Doug Jones. All rights reserved.

	Redistribution and use in source and binary forms, with or without
	modification, are permitted provided that the following conditions
	are met:
	
	a) Redistributions of source code must retain the above copyright
	   notice, this list of conditions and the following disclaimer.
	  
	b) Redistributions in binary form must reproduce the above copyright
	   notice, this list of conditions and the following disclaimer in the
	   documentation and/or other materials provided with the distribution. 
	  
	c) Neither the name of the Creative Juices, Bo. Co. nor the names of its
	   contributors may be used to endorse or promote products derived from
	   this software without specific prior written permission.
	
	THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
	"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
	LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
	A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
	OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
	SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
	LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
	DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
	THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
	(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
	OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

	For further information, visit the Creative Juices website: www.cjboco.com.
	
	Version History
	
	1.0.0 (09-20-2009) - Initial release.
	1.1.0 (10-07-2009) - Added the ability to have links
	1.1.1 (07-01-2010) - Fixed a minor issue with the offset

*********************************************************************************** */
(function ($) {
	$.fn.cjImageFlipBox = function (options) {

		/* 
			user variables (settings)
		***************************************/
		var settings = {
			// user editable settings
			debug: false
		};

		/* 
			system variables
		***************************************/
		var sys = {
			// function parameters
			version: '1.1.1',
			elem: null
		};

		/* 
			initialize the flipBox
		***************************************/

		function init() {

			var self = $(sys.elem).get(0);

			// show the mouse coordinates, if "debug" is set to true.
			if (settings.debug) {
				$(sys.elem).append('<div class="cj_image_flipbox_debugger" style="position: absolute; top: 1px; left: 1px; font-family: Arial, Helvetica, sans-serif; font-size: 10px; z-index: 10;"></div>');
			}

			// change cursor on mouseover
			$(sys.elem).hover(function () {
				$(this).css('cursor', 'pointer');
			}, function () {
				$(this).css('cursor', 'auto');
			});

			// count the images
			self.imgs = [];
			self.imgs = $(sys.elem).find("div.cj_image_flipbox_pics img");

			// determine if any of the images have links
			self.links = [];
			for (var i = 0; i < self.imgs.length; i++) {
				if (typeof $(self.imgs[i])[0] !== "undefined" && $(self.imgs[i])[0].parentNode.nodeName === "A") {
					self.links[i] = $(self.imgs[i]).parents("a:eq(0)")[0];
				} else {
					self.links[i] = null;
				}
			}

			// make sure we have some images to work with
			if (self.imgs.length > 0) {

				// create a new img that we can use to change out the picture
				$(sys.elem).find("div.cj_image_flipbox_pics").append('<a href="javascript:void(0);" class="cj_image_flipbox_link"><img src="' + self.imgs[0].src + '" width="' + self.imgs[0].width + '" height="' + self.imgs[0].height + '" alt="CJ Image Slider" class="cj_image_flipbox_img" /></a>');

				// hide all the images and add a new display img
				$(self.imgs).each(function () {
					$(this).css({
						"display": "none"
					});
				});

				// set the first image
				$(sys.elem).find("div.cj_image_flipbox_pics img.cj_image_flipbox_img").attr({
					"src": self.imgs[0].src
				});

				// set the link if available
				if (self.links[0]) {
					$(sys.elem).find("div.cj_image_flipbox_pics a.cj_image_flipbox_link").attr({
						"href": self.links[0].href,
						"title": self.links[0].title,
						"ref": self.links[0].ref
					});
				}

				// setup mouse tracking
				$(sys.elem).mousemove(function (e) {
					var self = this,
						pos = 0;
					// calculate the current mouse/image position
					pos = parseInt(((e.pageX - $(self).offset().left) / ($(self).width()) * self.imgs.length), 10);
					if (pos > self.imgs.length - 1) {
						pos = self.imgs.length - 1;
					}
					// setup the debug window, if debug is set to true
					if (settings.debug) {
						$(self).find(".cj_image_flipbox_debugger").html('x:' + (e.pageX - $(self).offset().left) + ', y:' + (e.pageY - $(self).offset().top) + ', cnt:' + self.imgs.length + ', w:' + $(sys.elem).width() + ', h:' + $(sys.elem).height() + ', pos:' + pos);
					}
					// set the image based on the mouse position
					$(self).find("div.cj_image_flipbox_pics img.cj_image_flipbox_img").attr({
						"src": self.imgs[pos].src
					});

					// set the link if available
					if (self.links[pos]) {
						$(sys.elem).find("div.cj_image_flipbox_pics a.cj_image_flipbox_link").attr({
							"href": self.links[pos].href,
							"title": self.links[pos].title,
							"ref": self.links[pos].ref
						});
					}
				});
			}

		}

		/* 
			set up any user passed variables
		***************************************/
		if (options) {
			$.extend(settings, options);
		}

		/* 
			main
		***************************************/
		return this.each(function () {
			sys.elem = this;
			init();
		});

	};
})(jQuery);