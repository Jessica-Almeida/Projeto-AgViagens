import React, { Component } from 'react';
import { StyleSheet, Text, View, FlatList, SafeAreaView } from 'react-native';

import api from './src/services/api';
import Destinos from './src/Destinos';



class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      destinos: []
    }
  }

  async componentDidMount() {
    const response = await api.get('api/destino')

    this.setState({
      destinos: response.data,
    });
  }


  render() {
    return (
      <SafeAreaView>
        <View style={styles.container}>
          <Text style={styles.titulo}>DESTINOS</Text>
          <FlatList
            data={this.state.destinos}
            keyExtractor={item => item.destinoId.toString()}
            renderItem={({ item }) => <Destinos data={item} />}
          />
        </View>
      </SafeAreaView>

    );
  }
}

export default App;

const styles = StyleSheet.create({
  container: {
    alignItems: 'center',
    justifyContent: 'center',
  },
  titulo: {
    fontWeight: 'bold',
    fontSize: 30,
  },

  
});
