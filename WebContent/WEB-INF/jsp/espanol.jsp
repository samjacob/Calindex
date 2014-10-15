<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="es-ES" >
   
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
		<meta content="IE=edge" http-equiv="X-UA-Compatible">
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Opt-Out | Cal INDEX</title>
		<link rel="stylesheet" id="bootstrap-css" href="css/cal-index.css" type="text/css" media="all"/>
		<link rel="stylesheet" id="gravity-css" href="css/form.css" type="text/css" media="all"/>
		<link rel="stylesheet" id="gforms_reset_css-css" href="css/formreset.css" type="text/css" media="all"/>
		<link rel="stylesheet" id="gforms_datepicker_css-css" href="css/datepicker.css" type="text/css" media="all"/>
		<link rel="stylesheet" id="gforms_formsmain_css-css" href="css/formsmain.css" type="text/css" media="all"/>
		<link rel="stylesheet" id="gforms_ready_class_css-css" href="css/readyclass.css" type="text/css" media="all"/>
		<link rel="stylesheet" id="gforms_browsers_css-css" href="css/browsers.css" type="text/css" media="all"/>
		<script type="text/javascript" src="./js/jquery.js"></script>
		<script type="text/javascript" src="./js/jquery-migrate.min.js"></script>
		<script type="text/javascript" src="./js/respond.min.js"></script>
		<script type="text/javascript" src="./js/conditional_logic.js"></script>
		<script type="text/javascript" src="./js/gravityforms.js"></script>
		<script type="text/javascript" src="./js/jquery.textareaCounter.plugin.js"></script>
		<meta http-equiv="Content-Language" content="es-ES">
		<link hreflang="en" href="https://www.calindex.org/opt-out/" rel="alternate"/>
		<!-- All in one Favicon 4.3 -->
		<link rel="shortcut icon" href="https://www.calindex.org/wp-content/uploads/2014/08/favicon.ico"/>
		<link rel="stylesheet" href="css/typekit.css"/>
	</head>
	<body>
		<div id="page" class="hfeed site">
			<header id="masthead" class="site-header" role="banner">
				<!-- Fixed navbar -->
				<div class="soc-navbar" role="navigation">
					<div class="menu-social-navigation-container">
						<ul id="menu-social-navigation" class="menu">
							<li id="menu-item-205" class="facebook menu-item">
								<a title="Facebook" target="_blank" href="http://facebook.com/calindex">Facebook</a>
							</li>
							<li id="menu-item-206" class="twitter menu-item">
								<a title="&nbsp;Twitter" target="_blank" href="http://twitter.com/thecalindex">&nbsp;Twitter</a>
							</li>
						</ul>
					</div>
				</div>
				<!-- Fixed navbar -->
				<div class="navbar main-nav" role="navigation">
					<div class="navbar-header">
						<div class="container">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<div class="logo">
								<a href="https://www.calindex.org/?lang=es" title="Cal INDEX" rel="home">
									<img class="img-responsive" src="https://www.calindex.org/wp-content/themes/cal-index/assets/imgs/logo.png" alt="Cal-Index logo">
								</a>
							</div>
						</div>
						<div class="collapse navbar-collapse navbar-ex1-collapse">
							<ul id="menu-main-navigation" class="nav navbar-nav">
								<li id="menu-item-19" class="menu-item"><a title="Value of Cal INDEX" href="https://www.calindex.org/value-of-cal-index/?lang=es">Value of Cal INDEX</a></li>
								<li class="menu-item"><a title="Products &amp; Services" href="https://www.calindex.org/products-services/?lang=es">Products &amp; Services</a></li>
								<li class="menu-item"><a title="Privacy &amp; Data Security" href="https://www.calindex.org/privacy-data-security/?lang=es">Privacy &amp; Data Security</a></li>
								<li class="menu-item"><a title="FAQ" href="https://www.calindex.org/faq/?lang=es">FAQ</a></li>
								<li class="menu-item facebook"><a title="&nbsp;Facebook" target="_blank" href="http://facebook.com/calindex"><span class="glyphicon Facebook"></span>&nbsp;&nbsp;Facebook</a></li>
								<li class="menu-item twitter "><a title="&nbsp;Twitter" target="_blank" href="http://twitter.com/thecalindex"><span class="glyphicon Twitter"></span>&nbsp;&nbsp;Twitter</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!-- Fixed navbar -->
				<div class="sub-navbar" role="navigation">
					<div class="navbar-header">
						<div class="collapse navbar-collapse navbar-ex1-collapse">
							<ul id="menu-sub-nav" class="nav navbar-nav">
								<li id="menu-item-38" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-38">
									<a title="About Us" href="https://www.calindex.org/about-us/?lang=es">About Us</a>
								</li>
								<li class="menu-item">
									<a title="News Center" href="https://www.calindex.org/news-center/?lang=es">News Center</a>
								</li>
								<li class="menu-item">
									<a title="CEO Blog" href="https://www.calindex.org/ceo-blog/?lang=es">CEO Blog</a>
								</li>
								<li class="menu-item current-menu-item active">
									<a title="Opt-Out" href="index.html">Opt-Out</a>
								</li>
								<li class="menu-item">
									<a title="Contact Us" href="https://www.calindex.org/contact-us/?lang=es">Contact Us</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</header>
				<!-- #masthead -->
			<div id="content" class="site-content">
				<div id="primary" class="content-area">
					<div class="site-main">
						<section class="inline-hero-image">
							<div class="hero-banner-inline-css" style="background-image: url('https://www.calindex.org/wp-content/uploads/2014/09/banner.png');">
								<div class="container">
									<div class="hero-caption">
										<h1>Cancelar la suscripci&oacute;n de		
											<br>Cal INDEX						
										</h1>
									</div>
									<!-- hero-caption -->
								</div>
								<!-- container -->
							</div>
							<!-- hero-banner-inline-css -->
						</section>
							<!-- Hero Banner -->
						<section>
							<div class="container">
								<article class="type-page">
									<header class="entry-header">
										<h2 class="entry-title">Opt-Out</h2>
										<span class="line-hightlight"></span>
									</header>
										<!-- .entry-header -->
									<div class="entry-content">
										<p>
											<a id="change_lang" class="btn-lang" href="optout.html" style="text-decoration: none;">English</a>
										</p>
										<p>
											<strong>C&oacute;mo cancelar la suscripci&oacute;n de Cal INDEX</strong>
										</p>
										<p>La participaci&oacute;n en Cal INDEX es totalmente gratuita y voluntaria. Para cancelar la suscripci&oacute;n en Cal INDEX, complete y env&iacute;e la siguiente informaci&oacute;n, llame al (888) 510-7142 o descargue, imprima y env&iacute;e por correo 																							
											<a href="/opt-out-manual/?lang=es">este formulario</a>.																						
										</p>
										<p>
											<strong>Qu&eacute; significa cancelar la suscripci&oacute;n de Cal INDEX</strong>
										</p>
										<p>Cuando cancela la suscripci&oacute;n de Cal INDEX, elige no compartir su informaci&oacute;n personal sobre la salud con su equipo de atenci&oacute;n de la salud y su plan de salud a trav&eacute;s del sistema de Cal INDEX.</p>
										<p>
											<strong>Qu&eacute; suceder&aacute; despu&eacute;s de cancelar la suscripci&oacute;n de Cal INDEX</strong>
										</p>
										<p>Se espera que el sistema de Cal INDEX empiece a funcionar a fines de 2014. Antes del lanzamiento, recibir&aacute; una confirmaci&oacute;n por correo electr&oacute;nico en la que se le indicar&aacute; que se ha procesado su solicitud de cancelaci&oacute;n de la suscripci&oacute;n. (Si la informaci&oacute;n que proporciona al momento de cancelar la suscripci&oacute;n se modifica antes de recibir la confirmaci&oacute;n, vuelva a enviar su solicitud). Una vez que se confirme la cancelaci&oacute;n de la suscripci&oacute;n, puede volver a suscribirse a Cal INDEX, pero esta funci&oacute;n no estar&aacute; disponible hasta principios de 2015.</p>
										<div class="gf_browser_unknown gform_wrapper" id="gform_wrapper_5" style="">
											<a id="gf_5" name="gf_5" class="gform_anchor"></a>
											<<form:form id="gform_4" modelAttribute="optOutForm">
												<div class="gform_body">
													<ul id="gform_fields_5" class="gform_fields top_label description_above">
														<li id="field_5_33" class="gfield">
															<label class="gfield_label"></label>
															<div class="ginput_container">
																<ul class="gfield_radio" id="input_5_33">
																	<li class="gchoice_33_0">
																		<input name="input_33" type="radio" value="I am filling out the form for myself." checked="checked" id="choice_33_0" tabindex="1" onclick="gf_apply_rules(5,[35,14,21,47,43,17,36,9,37,18,38]);">
																		<label for="choice_33_0" id="label_33_0">Complete el formulario en nombre propio</label>
																	</li>
																	<li class="gchoice_33_1">
																		<input name="input_33" type="radio" value="other" id="choice_33_1" tabindex="2" onclick="gf_apply_rules(5,[35,14,21,47,43,17,36,9,37,18,38]);">
																		<label for="choice_33_1" id="label_33_1">Complete el formulario en nombre de otra persona</label>
																	</li>
																</ul>
															</div>
														</li>
														<li id="field_5_35" class="gfield      gfield_html gfield_html_formatted gfield_no_follows_desc" style="display: none;">Si otra persona, que no sea quien desea cancelar la suscripci&oacute;n, presenta este formulario, la persona que lo env&iacute;a certifica que tiene autoridad legal para actuar en nombre de la persona que cancela la suscripci&oacute;n. (Por ejemplo, tutor legal o representante personal).</li>
														<li id="field_5_14" class="gfield               gfield_contains_required" style="display: none;">
															<label class="gfield_label" for="input_5_14">Especifique la relaci&oacute;n con la persona que cancela la suscripci&oacute;n																														
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="relationshipToTheOptedOutPerson"  name="input_14" id="input_5_14" type="text" value="" class="medium" maxlength="30" tabindex="3"/>
																<div class="charleft ginput_counter">0 de 30 caracteres m&aacute;ximos</div>
															</div>
														</li>
														<li id="field_5_21" class="gfield    gf_left_third           gfield_contains_required" style="display: none;">
															<label class="gfield_label" for="input_5_21">Nombre de la persona que completa el formulario																													
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="firstNameOfThePersonCompletingTheForm" name="input_21" id="input_5_21" type="text" value="" class="medium" maxlength="40" tabindex="4"/>
																<div class="charleft ginput_counter">0 de 40 caracteres m&aacute;ximos</div>
															</div>
														</li>
														<li id="field_5_47" class="gfield    gf_middle_third           gfield_contains_required" style="display: none;">
															<label class="gfield_label" for="input_5_47">Apellido de la persona que completa el formulario
																															
															<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="lastNameOfThePersonCompletingTheForm" name="input_47" id="input_5_47" type="text" value="" class="medium" tabindex="5"/>
															</div>
														</li>
														<li id="field_5_43" class="gfield    gf_right_third           gfield_contains_required" style="display: none;">
															<label class="gfield_label" for="input_5_43">N�mero de tel&eacute;fono de la persona que completa el formulario
																																
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="phoneNumberOfThePersonCompletingTheForm" name="input_43" id="input_5_43" type="text" value="" class="medium" tabindex="6"/>
															</div>
														</li>
														<li id="field_5_17" class="gfield    gf_left_third           gfield_contains_required" style="">
															<label class="gfield_label" for="input_5_17">Primer nombre
																																	
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="firstName" name="input_17" id="input_5_17" type="text" value="" class="medium" maxlength="40" tabindex="7"/>
																<div class="charleft ginput_counter">0 de 40 caracteres m&aacute;ximos</div>
															</div>
														</li>
														<li id="field_5_36" class="gfield    gf_left_third           gfield_contains_required" style="display: none;">
															<label class="gfield_label" for="input_5_36">Primer nombre de la persona que cancela la suscripci&oacute;n
																																		
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="firstName" name="input_36" id="input_5_36" type="text" value="" class="medium" maxlength="50" tabindex="8"/>
																<div class="charleft ginput_counter">0 de 50 caracteres m&aacute;ximos</div>
															</div>
														</li>
														<li id="field_5_9" class="gfield    gf_middle_third" style="">
															<label class="gfield_label" for="input_5_9">Segundo nombre</label>
															<div class="ginput_container">
																<form:input path="middleName" name="input_9" id="input_5_9" type="text" value="" class="medium" maxlength="40" tabindex="9"/>
																<div class="charleft ginput_counter">0 de 40 caracteres m&aacute;ximos</div>
															</div>
														</li>
														<li id="field_5_37" class="gfield    gf_middle_third" style="display: none;">
															<label class="gfield_label" for="input_5_37">Segundo nombre de la persona que cancela la suscripci&oacute;n</label>
															<div class="ginput_container">
																<form:input path="middleName" name="input_37" id="input_5_37" type="text" value="" class="medium" maxlength="40" tabindex="10"/>
																<div class="charleft ginput_counter">0 de 40 caracteres m&aacute;ximos</div>
															</div>
														</li>
														<li id="field_5_18" class="gfield    gf_right_third           gfield_contains_required" style="">
															<label class="gfield_label" for="input_5_18">Apellido
																																					
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="lastName" name="input_18" id="input_5_18" type="text" value="" class="medium" maxlength="40" tabindex="11"/>
																<div class="charleft ginput_counter">0 de 40 caracteres m&aacute;ximos</div>
															</div>
														</li>
														<li id="field_5_38" class="gfield    gf_right_third           gfield_contains_required" style="display: none;">
															<label class="gfield_label" for="input_5_38">Apellido de la persona que cancela la suscripci&oacute;n
																																						
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="lastName" name="input_38" id="input_5_38" type="text" value="" class="medium" maxlength="40" tabindex="12"/>
																<div class="charleft ginput_counter">0 de 40 caracteres m&aacute;ximos</div>
															</div>
														</li>
														<li id="field_5_3" class="gfield    gf_left_third           gfield_contains_required">
															<label class="gfield_label" for="input_5_3">Sexo
																																							
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:select path="gender" name="input_3" id="input_5_3" class="medium gfield_select" tabindex="13">
																	<option value="" selected="selected"></option>
																	<option value="Hombre">Hombre</option>
																	<option value="Mujer">Mujer</option>
																</form:select>
															</div>
														</li>
														<li id="field_5_2" class="gfield    gf_middle_third           gfield_contains_required">
															<label class="gfield_label" for="input_5_2">Fecha de nacimiento
																																							
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="dateOfBirth" name="input_2" id="input_5_2" type="text" value="" class="datepicker medium mdy datepicker_with_icon" tabindex="14" readonly=""/>
															</div>
															<input type="hidden" id="gforms_calendar_icon_input_5_2" class="gform_hidden" value="https://www.calindex.org/wp-content/plugins/gravityforms/images/calendar.png">
														</li>
														<li id="field_5_19" class="gfield    gf_left_half">
															<label class="gfield_label" for="input_5_19">Nombre anterior</label>
															<div class="ginput_container">
																<form:input path="previousFirstName" name="input_19" id="input_5_19" type="text" value="" class="medium" maxlength="40" tabindex="15"/>
																<div class="charleft ginput_counter">0 de 40 caracteres m&aacute;ximos</div>
															</div>
														</li>
														<li id="field_5_31" class="gfield    gf_right_half">
															<label class="gfield_label" for="input_5_31">Apellido anterior (por ejemplo, apellido de soltera)</label>
															<div class="ginput_container">
																<form:input path="previousLastName" name="input_31" id="input_5_31" type="text" value="" class="medium" maxlength="40" tabindex="16"/>
																<div class="charleft ginput_counter">0 de 40 caracteres m&aacute;ximos</div>
															</div>
														</li>
														<li id="field_5_20" class="gfield    gf_left_half           gfield_contains_required">
															<label class="gfield_label" for="input_5_20">Direcci&oacute;n o casilla postal
																																												
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="address" name="input_20" id="input_5_20" type="text" value="" class="medium" maxlength="50" tabindex="17"/>
																<div class="charleft ginput_counter">0 de 50 caracteres m&aacute;ximos</div>
															</div>
														</li>
														<li id="field_5_27" class="gfield    gf_right_half">
															<label class="gfield_label" for="input_5_27">Apartamento, suite u otro</label>
															<div class="ginput_container">
																<form:input path="apartmentNumber" name="input_27" id="input_5_27" type="text" value="" class="medium" maxlength="50" tabindex="18"/>
																<div class="charleft ginput_counter">0 de 50 caracteres m&aacute;ximos</div>
															</div>
														</li>
														<li id="field_5_28" class="gfield    gf_left_third           gfield_contains_required">
															<label class="gfield_label" for="input_5_28">Ciudad
																																														
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="city" name="input_28" id="input_5_28" type="text" value="" class="medium" maxlength="30" tabindex="19"/>
																<div class="charleft ginput_counter">0 de 30 caracteres m&aacute;ximos</div>
															</div>
														</li>
														<li id="field_5_30" class="gfield    gf_middle_third           gfield_contains_required">
															<label class="gfield_label" for="input_5_30">Estado
																																															
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:select path="state" name="input_30" id="input_5_30" class="medium gfield_select" tabindex="20">
																	<option value="" selected="selected"></option>
																	<option value="Alabama">Alabama</option>
																	<option value="Alaska">Alaska</option>
																	<option value="Arizona">Arizona</option>
																	<option value="Arkansas">Arkansas</option>
																	<option value="California">California</option>
																	<option value="Colorado">Colorado</option>
																	<option value="Connecticut">Connecticut</option>
																	<option value="Delaware">Delaware</option>
																	<option value="District of Columbia">District of Columbia</option>
																	<option value="Florida">Florida</option>
																	<option value="Georgia">Georgia</option>
																	<option value="Hawaii">Hawaii</option>
																	<option value="Idaho">Idaho</option>
																	<option value="Illinois">Illinois</option>
																	<option value="Indiana">Indiana</option>
																	<option value="Iowa">Iowa</option>
																	<option value="Kansas">Kansas</option>
																	<option value="Kentucky">Kentucky</option>
																	<option value="Louisiana">Louisiana</option>
																	<option value="Maine">Maine</option>
																	<option value="Maryland">Maryland</option>
																	<option value="Massachusetts">Massachusetts</option>
																	<option value="Michigan">Michigan</option>
																	<option value="Minnesota">Minnesota</option>
																	<option value="Mississippi">Mississippi</option>
																	<option value="Missouri">Missouri</option>
																	<option value="Montana">Montana</option>
																	<option value="Nebraska">Nebraska</option>
																	<option value="Nevada">Nevada</option>
																	<option value="New Hampshire">New Hampshire</option>
																	<option value="New Jersey">New Jersey</option>
																	<option value="New Mexico">New Mexico</option>
																	<option value="New York">New York</option>
																	<option value="North Carolina">North Carolina</option>
																	<option value="North Dakota">North Dakota</option>
																	<option value="Ohio">Ohio</option>
																	<option value="Oklahoma">Oklahoma</option>
																	<option value="Oregon">Oregon</option>
																	<option value="Pennsylvania">Pennsylvania</option>
																	<option value="Rhode Island">Rhode Island</option>
																	<option value="South Carolina">South Carolina</option>
																	<option value="South Dakota">South Dakota</option>
																	<option value="Tennessee">Tennessee</option>
																	<option value="Texas">Texas</option>
																	<option value="Utah">Utah</option>
																	<option value="Vermont">Vermont</option>
																	<option value="Virginia">Virginia</option>
																	<option value="Washington">Washington</option>
																	<option value="West Virginia">West Virginia</option>
																	<option value="Wisconsin">Wisconsin</option>
																	<option value="Wyoming">Wyoming</option>
																	<option value="Armed Forces Americas">Armed Forces Americas</option>
																	<option value="Armed Forces Europe">Armed Forces Europe</option>
																	<option value="Armed Forces Pacific">Armed Forces Pacific</option>
																</form:select>
															</div>
														</li>
														<li id="field_5_29" class="gfield    gf_right_third           gfield_contains_required">
															<label class="gfield_label" for="input_5_29">C&oacute;digo postal
																					
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="zipCode" name="input_29" id="input_5_29" type="text" value="" class="small" tabindex="21"/>
															</div>
														</li>
														<li id="field_5_5" class="gfield               gfield_contains_required">
															<label class="gfield_label" for="input_5_5">&iquest;Es miembro de un plan de salud?
																							
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:select path="healthPlanMember" name="input_5" id="input_5_5" onchange="gf_apply_rules(5,[6,7,8]);" class="small gfield_select" tabindex="22">
																	<option value="" selected="selected"></option>
																	<option value="Yes">Si</option>
																	<option value="No">No</option>
																</form:select>
															</div>
														</li>
														<li id="field_5_6" class="gfield    gf_left_third           gfield_contains_required" style="display: none;">
															<label class="gfield_label" for="input_5_6">Nombre del plan de salud
																										
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:select path="healthPlanName"  name="input_6" id="input_5_6" onchange="gf_apply_rules(5,[34,7,23,8,24]);" class="medium gfield_select" tabindex="23">
																	<option value="" selected="selected"></option>
																	<option value="Blue Shield of California">Blue Shield of California</option>
																	<option value="Anthem Blue Cross">Anthem Blue Cross</option>
																	<option value="Other">Otro</option>
																</form:select>
															</div>
														</li>
														<li id="field_5_34" class="gfield    gf_middle_third           gfield_contains_required" style="display: none;">
															<label class="gfield_label" for="input_5_34">Otro Nombre del Plan de Salud
																										
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="otherHealthPlanName" name="input_34" id="input_5_34" type="text" value="" class="medium" maxlength="30" tabindex="24"/>
																	<div class="charleft ginput_counter">0 de 30 caracteres m&aacute;ximos</div>
															</div>
															<div class="gfield_description">Ingrese el nombre de su plan de salud.</div>
														</li>
														<li id="field_5_7" class="gfield    gf_left_third           gfield_contains_required" style="display: none;">
															<label class="gfield_label" for="input_5_7">Identificaci&oacute;n del grupo
																										
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="groupId" name="input_7" id="input_5_7" type="text" value="" class="medium" maxlength="30" tabindex="25"/>
																	<div class="charleft ginput_counter">0 de 30 caracteres m&aacute;ximos</div>
															</div>
															<div class="gfield_description">Consulte su tarjeta de identificaci&oacute;n del seguro de salud.</div>
														</li>
														<li id="field_5_23" class="gfield    gf_middle_third           gfield_contains_required" style="display: none;">
															<label class="gfield_label" for="input_5_23">N�mero de grupo
																										
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="groupNumber" name="input_23" id="input_5_23" type="text" value="" class="medium" maxlength="30" tabindex="26"/>
																	<div class="charleft ginput_counter">0 de 30 caracteres m&aacute;ximos</div>
															</div>
															<div class="gfield_description">Consulte su tarjeta de identificaci&oacute;n del seguro de salud.</div>
														</li>
														<li id="field_5_8" class="gfield    gf_middle_third           gfield_contains_required" style="display: none;">
															<label class="gfield_label" for="input_5_8">Identificaci&oacute;n del Suscriptor
																										
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="subscriberId" name="input_8" id="input_5_8" type="text" value="" class="medium" maxlength="30" tabindex="27"/>
																	<div class="charleft ginput_counter">0 de 30 caracteres m&aacute;ximos</div>
															</div>
															<div class="gfield_description">Consulte su tarjeta de identificaci&oacute;n del seguro de salud.</div>
														</li>
														<li id="field_5_24" class="gfield    gf_right_third           gfield_contains_required" style="display: none;">
															<label class="gfield_label" for="input_5_24">N�mero de Identificaci&oacute;n
																										
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="identificationNumber" name="input_24" id="input_5_24" type="text" value="" class="medium" maxlength="30" tabindex="28"/>
																	<div class="charleft ginput_counter">0 de 30 caracteres m&aacute;ximos</div>
															</div>
															<div class="gfield_description">Consulte su tarjeta de identificaci&oacute;n del seguro de salud.</div>
														</li>
														<li id="field_5_11" class="gfield    gf_left_half           gfield_contains_required">
															<label class="gfield_label" for="input_5_11">Correo electr&oacute;nico
																										
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_complex ginput_container" id="input_5_11_container">
																<span id="input_5_11_1_container" class="ginput_left">
																	<form:input path="email" type="text" name="input_11" id="input_5_11" value="" tabindex="29"/>
																		<label for="input_5_11">Ingrese su Email</label>
																</span>
																<span id="input_5_11_2_container" class="ginput_right">
																	<input type="text" name="input_11_2" id="input_5_11_2" value="" tabindex="30"/>
																	<label for="input_5_11_2">Confirmar Email</label>
																</span>
																<div class="gf_clear gf_clear_complex"></div>
															</div>
														</li>
														<li id="field_5_46" class="gfield    gf_right_half           gfield_contains_required">
															<label class="gfield_label" for="input_5_46">Tel&eacute;fono Principal
																										
																<span class="gfield_required">*</span>
															</label>
															<div class="ginput_container">
																<form:input path="phoneNumber" name="input_46" id="input_5_46" type="text" value="" class="medium" tabindex="31"/>
															</div>
														</li>
														<li id="field_5_44" class="gfield    gf_right_half">
															<label class="gfield_label" for="input_5_44">Tel&eacute;fono Alternativo</label>
															<div class="ginput_container">
																<form:input path="alternatePhoneNumber" name="input_44" id="input_5_44" type="text" value="" class="medium" tabindex="32"/>
															</div>
														</li>
														<li id="field_5_39" class="gfield      gfield_html gfield_html_formatted gfield_no_follows_desc">Solo puede decidir cancelar la suscripci&oacute;n de Cal INDEX propia y la de aquellas personas a quienes est&aacute; autorizado a representar conforme a la ley, como un menor, otro dependiente legal o alguna persona que le haya otorgado el poder notarial para su atenci&oacute;n de la salud. Cal INDEX se reserva el derecho de solicitar la presentaci&oacute;n de constancias que demuestren su autoridad cuando act&uacute;e en representaci&oacute;n de otra persona. Las personas que presenten informaci&oacute;n falsa pueden ser pasibles de acciones penales o civiles por fraude o testimonio falso.</li>
														<li id="field_4_46" class="gfield">
															<label class="gfield_label" for="input_4_45">CAPTCHA</label>
															<div class="ginput_container">
																<div id="recaptcha_widget_div" class=" recaptcha_nothad_incorrect_sol recaptcha_isnot_showing_audio"></div>
															</div>

															<script type="text/javascript" src="https://www.google.com/recaptcha/api/challenge?k=6Ld68voSAAAAAPCA0env-LoLEkgfeEO96Bo0MN7m&hl=en"></script>
															<noscript>
																<iframe src="http://www.google.com/recaptcha/api/noscript?k=6Ld68voSAAAAAPCA0env-LoLEkgfeEO96Bo0MN7m" height="300" width="500" frameborder="0"></iframe>
																	<br>
																<textarea name="recaptcha_challenge_field" rows="3" cols="40"></textarea>
																<input type="hidden" name="recaptcha_response_field" value="manual_challenge"/>
															</noscript>
														</li>
														<li id="field_5_48" class="gfield      gfield_html gfield_html_formatted gfield_no_follows_desc">Revise la informaci&oacute;n antes de hacer clic en el bot&oacute;n Enviar o, si desea abandonar esta p&aacute;gina sin enviar la informaci&oacute;n, haga clic en Cancelar para salir y regresar a la p&aacute;gina de inicio.</li>
													</ul>
												</div>
												<div class="gform_footer top_label">
													<input type="submit" id="gform_submit_button_5" class="gform_button button" value="Presentar" tabindex="34" onclick="if(window[&quot;gf_submitting_5&quot;]){return false;}  window[&quot;gf_submitting_5&quot;]=true; ">
													<a class="form-cancel" href="/">Cancelar</a>
												</div>
											</form:form>
										</div>
										
									</div>
									<!-- .entry-content -->
								</article>
								<!-- #post-## -->
							</div>
							<!-- container -->
						</section>
					</div>
					<!-- #main -->
				</div>
				<!-- #primary -->
			</div>
				<!-- #content -->
				<div id="push"></div>
		</div>
		<!-- #page -->
		<footer id="colophon" class="site-footer" role="contentinfo">
			<div class="site-info container">
				<div class="float-left">
					<ul>
						<li>
							<p>Copyright � 2014 Cal INDEX</p>
							<span class="sep">|</span>
						</li>
						<li>
							<a href="https://www.calindex.org/terms-of-use">Terms of use</a>
							<span class="sep">|</span>
						</li>
						<li>
							<a href="https://www.calindex.org/legal/">Legal</a>
						</li>
					</ul>
				</div>
				<div class="float-right">
					<p class="float-left">Still have questions about Cal INDEX?</p>
					<a href="https://www.calindex.org/faq" class="btn btn-primary float-right">Read FAQs</a>
				</div>
			</div>
			<!-- .site-info -->
		</footer>
		<!-- #colophon -->
		<script type="text/javascript" src="./js/bootstrap.min.js"></script>
		<script type="text/javascript" src="./js/jquery.ui.core.min.js"></script>
		<script type="text/javascript" src="./js/jquery.ui.datepicker.min.js"></script>
		<script type="text/javascript" src="./js/validate.js"></script>
		<script type="text/javascript" src="./js/custom.js"></script>
		<script type="text/javascript" src="./js/challenge.js"></script>
		<script type="text/javascript">
			try{Typekit.load();}catch(e){}
			var RecaptchaOptions = {theme : 'white'}; if(parseInt('33') > 0) {RecaptchaOptions.tabindex = 33;};
			if(typeof gf_global == 'undefined') var gf_global = {"gf_currency_config":{"name":"D\u00f3lar Americano","symbol_left":"$","symbol_right":"","symbol_padding":"","thousand_separator":",","decimal_separator":".","decimals":2},"base_url":"https:\/\/www.calindex.org\/wp-content\/plugins\/gravityforms","number_formats":[],"spinnerUrl":"https:\/\/www.calindex.org\/wp-content\/plugins\/gravityforms\/images\/spinner.gif"};jQuery(document).bind('gform_post_render', function(event, formId, currentPage){if(formId == 5) {if(window['jQuery']){if(!window['gf_form_conditional_logic'])window['gf_form_conditional_logic'] = new Array();window['gf_form_conditional_logic'][5] = {'logic' : {35: {"field":{"actionType":"show","logicType":"all","rules":[{"fieldId":"33","operator":"is","value":"other"}]},"nextButton":null,"section":null},14: {"field":{"actionType":"show","logicType":"all","rules":[{"fieldId":"33","operator":"is","value":"other"}]},"nextButton":null,"section":null},21: {"field":{"actionType":"show","logicType":"all","rules":[{"fieldId":"33","operator":"is","value":"other"}]},"nextButton":null,"section":null},47: {"field":{"actionType":"show","logicType":"all","rules":[{"fieldId":"33","operator":"is","value":"other"}]},"nextButton":null,"section":null},43: {"field":{"actionType":"show","logicType":"all","rules":[{"fieldId":"33","operator":"is","value":"other"}]},"nextButton":null,"section":null},17: {"field":{"actionType":"show","logicType":"all","rules":[{"fieldId":"33","operator":"is","value":"I am filling out the form for myself."}]},"nextButton":null,"section":null},36: {"field":{"actionType":"show","logicType":"all","rules":[{"fieldId":"33","operator":"is","value":"other"}]},"nextButton":null,"section":null},9: {"field":{"actionType":"show","logicType":"all","rules":[{"fieldId":"33","operator":"is","value":"I am filling out the form for myself."}]},"nextButton":null,"section":null},37: {"field":{"actionType":"show","logicType":"all","rules":[{"fieldId":"33","operator":"is","value":"other"}]},"nextButton":null,"section":null},18: {"field":{"actionType":"show","logicType":"all","rules":[{"fieldId":"33","operator":"is","value":"I am filling out the form for myself."}]},"nextButton":null,"section":null},38: {"field":{"actionType":"show","logicType":"all","rules":[{"fieldId":"33","operator":"is","value":"other"}]},"nextButton":null,"section":null},6: {"field":{"actionType":"show","logicType":"all","rules":[{"fieldId":"5","operator":"is","value":"Yes"}]},"nextButton":null,"section":null},34: {"field":{"actionType":"show","logicType":"all","rules":[{"fieldId":"6","operator":"is","value":"Other"}]},"nextButton":null,"section":null},7: {"field":{"actionType":"show","logicType":"all","rules":[{"fieldId":"6","operator":"isnot","value":"Anthem Blue Cross"},{"fieldId":"6","operator":"isnot","value":""},{"fieldId":"5","operator":"is","value":"Yes"}]},"nextButton":null,"section":null},23: {"field":{"actionType":"show","logicType":"any","rules":[{"fieldId":"6","operator":"is","value":"Anthem Blue Cross"}]},"nextButton":null,"section":null},8: {"field":{"actionType":"show","logicType":"all","rules":[{"fieldId":"6","operator":"isnot","value":"Anthem Blue Cross"},{"fieldId":"6","operator":"isnot","value":""},{"fieldId":"5","operator":"is","value":"Yes"}]},"nextButton":null,"section":null},24: {"field":{"actionType":"show","logicType":"any","rules":[{"fieldId":"6","operator":"is","value":"Anthem Blue Cross"}]},"nextButton":null,"section":null} }, 'dependents' : {35: [35],14: ["14"],21: ["21"],47: [47],43: [43],17: ["17"],36: [36],9: ["9"],37: [37],18: ["18"],38: [38],6: ["6"],34: ["34"],7: ["7"],23: ["23"],8: ["8"],24: ["24"] }, 'animation' : 0 , 'defaults' : {"33":["choice_33_0"],"3":"","30":"","5":"","6":""} }; if(!window['gf_number_format'])window['gf_number_format'] = 'decimal_comma';jQuery(document).ready(function(){gf_apply_rules(5, [35,"14","21",47,43,"17",36,"9",37,"18",38,"6","34","7","23","8","24"], true);jQuery('#gform_wrapper_5').show();jQuery(document).trigger('gform_post_conditional_logic', [5, null, true]);} );} jQuery('#input_5_14').textareaCount(    {    'maxCharacterSize': 30,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_21').textareaCount(    {    'maxCharacterSize': 40,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_17').textareaCount(    {    'maxCharacterSize': 40,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_36').textareaCount(    {    'maxCharacterSize': 50,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_9').textareaCount(    {    'maxCharacterSize': 40,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_37').textareaCount(    {    'maxCharacterSize': 40,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_18').textareaCount(    {    'maxCharacterSize': 40,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_38').textareaCount(    {    'maxCharacterSize': 40,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_19').textareaCount(    {    'maxCharacterSize': 40,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_31').textareaCount(    {    'maxCharacterSize': 40,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_20').textareaCount(    {    'maxCharacterSize': 50,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_27').textareaCount(    {    'maxCharacterSize': 50,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_28').textareaCount(    {    'maxCharacterSize': 30,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_34').textareaCount(    {    'maxCharacterSize': 30,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_7').textareaCount(    {    'maxCharacterSize': 30,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_23').textareaCount(    {    'maxCharacterSize': 30,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_8').textareaCount(    {    'maxCharacterSize': 30,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );jQuery('#input_5_24').textareaCount(    {    'maxCharacterSize': 30,    'originalStyle': 'ginput_counter',    'displayFormat' : '#input de #max caracteres m&aacute;ximos'    } );} } );jQuery(document).bind('gform_post_conditional_logic', function(event, formId, fields, isInit){} );
			jQuery(document).ready(function(){jQuery(document).trigger('gform_post_render', [5, 1]) } );

			function submitForm(){
		 		 document.forms[0].action="captureData.html";
		 		 document.forms[0].submit();
		 	}
		</script>
	</body>
</html>