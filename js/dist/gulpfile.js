const gulp = require('gulp');
const sass = require('gulp-sass')(require('sass'));  // SCSS 컴파일러 설정
const cleanCss = require("gulp-clean-css");


//자바스크립트 파일을 minify
gulp.task('uglify', function() {
    return gulp.src('/nxt/html/js/*.js')
        .pipe(gulp.dest('dist'));
});
// gulp를 실행하면 default로 uglify task를 실행
gulp.task('default', gulp.series('uglify'));


//clean css
gulp.task('cleanCss', function() {
	 return gulp.src('/nxt/html/css/*.css')
	.pipe(cleanCss({ compatibiliy: 'ie8' })) 
	.pipe(gulp.dest("/nxt/html/dist/css/"))
});



// SCSS를 컴파일하고 자동 접기 설정
gulp.task('styles', function() {
    return gulp.src('/nxt/html/scss/**/*.scss')   // SCSS 소스 경로
        .pipe(sass().on('error', sass.logError))  // SCSS 컴파일 및 오류 로그
        .pipe(gulp.dest('/nxt/html/css/'));  // 컴파일된 CSS 저장 경로
});


// 파일 변경 감지하여 자동 컴파일
gulp.task('watch', function() {
    gulp.watch('/nxt/html/scss/**/*.scss', gulp.series('styles'));
});

// 기본 작업
gulp.task('default', gulp.series('styles', 'cleanCss', 'uglify', 'watch'));

/*const gulp = require('gulp');
const uglify = require('gulp-uglify');
const concat = require('gulp-concat');
const sourcemaps = require('gulp-sourcemaps');
const scss = require('gulp-sass')(require('sass'));
const cleanCss = require("gulp-clean-css");

const paths = {
	js: ['./js/*.js'],
	scss: ['./sass/*.scss'],
	css: ['./css/*.css']
};

var scssOptions = {
	outputStyle: "expanded",
	indentType: "tab",
	indentWidth: 1,
	precision: 6,
	sourceComments: true
};


// SCSS Compile Task
gulp.task('scss', function() {
	return gulp.src(paths.scss)
		.pipe(sourcemaps.init())
		.pipe(scss(scssOptions).on('error', scss.logError))
		.pipe(sourcemaps.write('.'))
		.pipe(gulp.dest('css'));
});


// Minify JavaScript Task
gulp.task('uglify', function() {
	return gulp.src(paths.js)
		.pipe(concat('main.min.js')) // Merge
		.pipe(uglify()) // Minify
		.pipe(gulp.dest('dist/js'));
});

// Watch Task
gulp.task('watch', function() {
	gulp.watch(paths.js, gulp.series('uglify'));
	gulp.watch(paths.scss, gulp.series('scss'));
});

// Default Task
gulp.task('default', gulp.parallel('uglify', 'scss', 'cleanCss','watch'));*/