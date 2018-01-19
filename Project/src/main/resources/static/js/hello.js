var demo = angular.module('demo', [ "ngRoute", "ngAnimate"]);

demo.run(function($rootScope) {
    $rootScope.data = {};
    $rootScope.data.reagent = 0;
 });

demo.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "home.html",
		animation : "pageAnimated"
	}).when("/reagents", {
		templateUrl : "reagents.html",
		controller : "reagentsController"
	}).when("/reagents_edit", {
		templateUrl : "reagents_edit.html",
		controller : "reagentEditController"
	}).when("/reagents_delete", {
		templateUrl : "reagents_delete.html",
		controller : "reagentDeleteController"
	}).when("/about_me", {
		templateUrl : "about_me.html"
	}).when("/contact_me", {
		templateUrl : "contact_me.html"
	}).when("/publications", {
		templateUrl : "publications.html"
	}).when("/login", {
		templateUrl : "login.html"
	}).when("/login?error", {
		templateUrl : "login.html"
	}).when("/finish", {
		templateUrl : "finish.html"
	}).when("/reagents_new", {
		templateUrl : "reagents_new.html",
		controller : "reagentNewController"
	})
});