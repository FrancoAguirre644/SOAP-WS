from flask import Flask, jsonify, request
from flask_cors import CORS
from suds.client import Client as SudsClient

app = Flask(__name__)

client = SudsClient(url='http://localhost:8080/ws/countries.wsdl', cache=None)

CORS(app)

@app.route('/soap/countries', methods=['GET'])
def getAllCountries():
    r = client.service.getAllCountries()
    
    listCountries = []

    for obj in r:
        listCountries.append(getCountry(obj))

    return jsonify({'data': listCountries})


@app.route('/soap/countries/<id>', methods=['GET'])
def getCountry(id):
    r = client.service.getCountry(id=id)

    if(r):
        r = getCountry(r)

    return jsonify({
        'country': r
    })


@app.route('/soap/countries', methods=['POST'])
def createCountry():
    r = client.service.createCountry(**request.get_json())

    print(getCountry(r.country))

    print(getResponse(r.responseStatus))

    return jsonify({
        'message' : getResponse(r.responseStatus)['message'],
        'country': getCountry(r.country)
    })


@app.route('/soap/countries/<id>', methods=['PUT'])
def updateCountry(id):

    r = client.service.updateCountry(**request.get_json())

    return jsonify({'responseStatus' : getResponse(r)})


@app.route('/soap/countries/<id>', methods=['DELETE'])
def deleteCountry(id):

    r = client.service.deleteCountry(id=id)

    return jsonify({'responseStatus' : getResponse(r)})

def getCountry(soapCountry):
    country = {}
    for key in soapCountry.__keylist__:
        country[key] = soapCountry[key]

    return country

def getResponse(soapResponse):
    response = {}
    for key in soapResponse.__keylist__:
        response[key] = soapResponse[key]

    return response

if __name__=='__main__':
	app.run(debug=True)