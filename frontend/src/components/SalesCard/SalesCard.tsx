import './SalesCard.css'
import NotificationButton from '../NotificationButton/NotificationButton'
import DatePicker from 'react-datepicker'
import 'react-datepicker/dist/react-datepicker.css'
import { useEffect, useState } from 'react'
import axios from 'axios'
import { BASE_URL } from '../../utils/resquest' // Definimos o caminho da API dentro do arquivo "request.ts".
import { Sale } from '../../models/Sale'

const SalesCard = () => {
  const [minDate, setMinDate] = useState(
    new Date(new Date().setDate(new Date().getDate() - 365))
  )
  const [maxDate, setMaxDate] = useState(new Date())

  const [sales, setSales] = useState<Sale[]>([])

  // estamos usando o template string para passar a URL padrão da API + o endpoint das vendas!
  useEffect(() => {
    axios.get(`${BASE_URL}/sales`).then(response => {
      setSales(response.data.content)
    })
  }, [])

  return (
    <div>
      <div className="dsmeta-card">
        <h2 className="dsmeta-sales-title">Vendas</h2>
        <div>
          <div className="dsmeta-form-control-container">
            <DatePicker
              selected={minDate}
              onChange={(date: Date) => setMinDate(date)}
              className="dsmeta-form-control"
              dateFormat="dd/MM/yyyy"
            />
          </div>
          <div className="dsmeta-form-control-container">
            <DatePicker
              selected={maxDate}
              onChange={(date: Date) => setMaxDate(date)}
              className="dsmeta-form-control"
              dateFormat="dd/MM/yyyy"
            />
          </div>
        </div>
        <div>
          <table className="dsmeta-sales-table">
            <thead>
              <tr>
                <th className="tc992">ID</th>
                <th className="tc576">Data</th>
                <th>Vendedor</th>
                <th className="tc992">Visitas</th>
                <th className="tc992">Vendas</th>
                <th>Total</th>
                <th>Notificar</th>
              </tr>
            </thead>
            <tbody>
              {sales.map(sale => {
                return (
                  <tr key={sale.id}>
                    <th className="tc992">{sale.id}</th>
                    <th className="tc576">
                      {new Date(sale.date).toLocaleDateString()}
                    </th>
                    <th>{sale.sellerName}</th>
                    <th className="tc992">{sale.visited}</th>
                    <th className="tc992">{sale.deals}</th>
                    <th>R$ {sale.amount.toFixed(2)}</th>
                    <NotificationButton />
                  </tr>
                )
              })}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  )
}

export default SalesCard
