'use-strict';

var express         = require('express'),
    path            = require('path'),
    morgan          = require('morgan'),
    cookieParser    = require('cookie-parser'),
    bodyParser      = require('body-parser'),
    methodOverride  = require('method-override'),
    errorHandler    = require('errorhandler'),
    compress        = require('compression'),
    multipart       = require('connect-multiparty'),
    helmet          = require('helmet');

var expose          = require('./modules/expose/index')(express),
    routes          = require('./modules/main/routes')(express),
    partials        = require('./modules/expose/partials')(express),
    api             = {},
    app             = express();

api.uriRouter   = require('./modules/main/api/uri.router')(express);

app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json());
app.use(methodOverride());
app.use(compress());
app.use(express.static(path.join(__dirname, '../front')));
app.use(morgan('dev'));
app.use(cookieParser());
app.use(helmet());
app.use(helmet.xframe());
app.use(helmet.xssFilter());
app.use(helmet.nosniff());
app.disabled('x-powered-by');
app.use(multipart({uploadDir: '/'}));
app.set('views', path.join(__dirname, '/modules'));
app.set('view engine', 'jade');
app.use('/', routes);
app.use('/api', api.uriRouter);
app.use('/expose', expose);
app.use('/partials', partials);

module.exports = app;