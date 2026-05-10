export default function App() {
  const doctors = [
    {
      name: 'Dr. Priya Sharma',
      specialization: 'Cardiologist',
      experience: '10 Years',
    },
    {
      name: 'Dr. Arjun Rao',
      specialization: 'Dermatologist',
      experience: '7 Years',
    },
    {
      name: 'Dr. Neha Verma',
      specialization: 'Pediatrician',
      experience: '12 Years',
    },
  ];

  return (
    <div className="min-h-screen bg-gray-100">
      <nav className="bg-white shadow-md px-8 py-4 flex justify-between items-center">
        <h1 className="text-2xl font-bold text-blue-700">
          HealthCare Booking
        </h1>

        <div className="space-x-6 text-gray-700 font-medium">
          <button>Home</button>
          <button>Doctors</button>
          <button>Appointments</button>
          <button>Contact</button>
        </div>
      </nav>

      <section className="bg-blue-700 text-white py-20 px-10 text-center">
        <h2 className="text-5xl font-bold mb-6">
          Book Your Doctor Appointment Online
        </h2>

        <p className="text-lg max-w-3xl mx-auto mb-8">
          Find experienced doctors and manage appointments easily.
        </p>

        <button className="bg-white text-blue-700 px-8 py-3 rounded-2xl font-semibold">
          Book Appointment
        </button>
      </section>

      <section className="px-10 py-10">
        <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
          {doctors.map((doctor, index) => (
            <div
              key={index}
              className="bg-white rounded-3xl shadow-lg p-6"
            >
              <div className="w-24 h-24 bg-blue-100 rounded-full mx-auto mb-4"></div>

              <h3 className="text-xl font-bold text-center text-gray-800">
                {doctor.name}
              </h3>

              <p className="text-center text-blue-700 mt-2">
                {doctor.specialization}
              </p>

              <p className="text-center text-gray-500 mt-1">
                {doctor.experience}
              </p>

              <button className="mt-6 w-full bg-blue-700 text-white py-3 rounded-xl">
                Book Now
              </button>
            </div>
          ))}
        </div>
      </section>
    </div>
  );
}
