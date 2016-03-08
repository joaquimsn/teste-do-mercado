module.exports = function (express) {
  "use strict";
  var router    = express.Router(),
      os        = require('os'),
      config    = require('./../../../config/config')();

  router.get('/system/uri', function (req, res) {
    var interfaces = os.networkInterfaces();
    var addresses = [];
    for (var k in interfaces) {
        for (var k2 in interfaces[k]) {
            var address = interfaces[k][k2];
            if (address.family === 'IPv4' && !address.internal) {
                addresses.push(address.address);
            }
        }
    }
    res.json('http://' + addresses[0] + ':' + config.api.port);
  });

  return router;
};